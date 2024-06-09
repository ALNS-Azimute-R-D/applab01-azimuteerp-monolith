import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject, from } from 'rxjs';

import { IPerson } from 'app/entities/person/person.model';
import { PersonService } from 'app/entities/person/service/person.service';
import { IProduct } from 'app/entities/product/product.model';
import { ProductService } from 'app/entities/product/service/product.service';
import { ISupplier } from '../supplier.model';
import { SupplierService } from '../service/supplier.service';
import { SupplierFormService } from './supplier-form.service';

import { SupplierUpdateComponent } from './supplier-update.component';

describe('Supplier Management Update Component', () => {
  let comp: SupplierUpdateComponent;
  let fixture: ComponentFixture<SupplierUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let supplierFormService: SupplierFormService;
  let supplierService: SupplierService;
  let personService: PersonService;
  let productService: ProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, SupplierUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(SupplierUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(SupplierUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    supplierFormService = TestBed.inject(SupplierFormService);
    supplierService = TestBed.inject(SupplierService);
    personService = TestBed.inject(PersonService);
    productService = TestBed.inject(ProductService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Person query and add missing value', () => {
      const supplier: ISupplier = { id: 456 };
      const representativePerson: IPerson = { id: 17407 };
      supplier.representativePerson = representativePerson;

      const personCollection: IPerson[] = [{ id: 23889 }];
      jest.spyOn(personService, 'query').mockReturnValue(of(new HttpResponse({ body: personCollection })));
      const additionalPeople = [representativePerson];
      const expectedCollection: IPerson[] = [...additionalPeople, ...personCollection];
      jest.spyOn(personService, 'addPersonToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ supplier });
      comp.ngOnInit();

      expect(personService.query).toHaveBeenCalled();
      expect(personService.addPersonToCollectionIfMissing).toHaveBeenCalledWith(
        personCollection,
        ...additionalPeople.map(expect.objectContaining),
      );
      expect(comp.peopleSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Product query and add missing value', () => {
      const supplier: ISupplier = { id: 456 };
      const toProducts: IProduct[] = [{ id: 10707 }];
      supplier.toProducts = toProducts;

      const productCollection: IProduct[] = [{ id: 25843 }];
      jest.spyOn(productService, 'query').mockReturnValue(of(new HttpResponse({ body: productCollection })));
      const additionalProducts = [...toProducts];
      const expectedCollection: IProduct[] = [...additionalProducts, ...productCollection];
      jest.spyOn(productService, 'addProductToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ supplier });
      comp.ngOnInit();

      expect(productService.query).toHaveBeenCalled();
      expect(productService.addProductToCollectionIfMissing).toHaveBeenCalledWith(
        productCollection,
        ...additionalProducts.map(expect.objectContaining),
      );
      expect(comp.productsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const supplier: ISupplier = { id: 456 };
      const representativePerson: IPerson = { id: 25466 };
      supplier.representativePerson = representativePerson;
      const toProduct: IProduct = { id: 4528 };
      supplier.toProducts = [toProduct];

      activatedRoute.data = of({ supplier });
      comp.ngOnInit();

      expect(comp.peopleSharedCollection).toContain(representativePerson);
      expect(comp.productsSharedCollection).toContain(toProduct);
      expect(comp.supplier).toEqual(supplier);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISupplier>>();
      const supplier = { id: 123 };
      jest.spyOn(supplierFormService, 'getSupplier').mockReturnValue(supplier);
      jest.spyOn(supplierService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ supplier });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: supplier }));
      saveSubject.complete();

      // THEN
      expect(supplierFormService.getSupplier).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(supplierService.update).toHaveBeenCalledWith(expect.objectContaining(supplier));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISupplier>>();
      const supplier = { id: 123 };
      jest.spyOn(supplierFormService, 'getSupplier').mockReturnValue({ id: null });
      jest.spyOn(supplierService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ supplier: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: supplier }));
      saveSubject.complete();

      // THEN
      expect(supplierFormService.getSupplier).toHaveBeenCalled();
      expect(supplierService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<ISupplier>>();
      const supplier = { id: 123 };
      jest.spyOn(supplierService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ supplier });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(supplierService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('comparePerson', () => {
      it('Should forward to personService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(personService, 'comparePerson');
        comp.comparePerson(entity, entity2);
        expect(personService.comparePerson).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareProduct', () => {
      it('Should forward to productService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(productService, 'compareProduct');
        comp.compareProduct(entity, entity2);
        expect(productService.compareProduct).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});

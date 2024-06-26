import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../product.test-samples';

import { ProductFormService } from './product-form.service';

describe('Product Form Service', () => {
  let service: ProductFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductFormService);
  });

  describe('Service methods', () => {
    describe('createProductFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createProductFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            productSKU: expect.any(Object),
            productName: expect.any(Object),
            description: expect.any(Object),
            standardCost: expect.any(Object),
            listPrice: expect.any(Object),
            reorderLevel: expect.any(Object),
            targetLevel: expect.any(Object),
            quantityPerUnit: expect.any(Object),
            discontinued: expect.any(Object),
            minimumReorderQuantity: expect.any(Object),
            suggestedCategory: expect.any(Object),
            attachments: expect.any(Object),
            activationStatus: expect.any(Object),
            brand: expect.any(Object),
            toSuppliers: expect.any(Object),
          }),
        );
      });

      it('passing IProduct should create a new form with FormGroup', () => {
        const formGroup = service.createProductFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            productSKU: expect.any(Object),
            productName: expect.any(Object),
            description: expect.any(Object),
            standardCost: expect.any(Object),
            listPrice: expect.any(Object),
            reorderLevel: expect.any(Object),
            targetLevel: expect.any(Object),
            quantityPerUnit: expect.any(Object),
            discontinued: expect.any(Object),
            minimumReorderQuantity: expect.any(Object),
            suggestedCategory: expect.any(Object),
            attachments: expect.any(Object),
            activationStatus: expect.any(Object),
            brand: expect.any(Object),
            toSuppliers: expect.any(Object),
          }),
        );
      });
    });

    describe('getProduct', () => {
      it('should return NewProduct for default Product initial value', () => {
        const formGroup = service.createProductFormGroup(sampleWithNewData);

        const product = service.getProduct(formGroup) as any;

        expect(product).toMatchObject(sampleWithNewData);
      });

      it('should return NewProduct for empty Product initial value', () => {
        const formGroup = service.createProductFormGroup();

        const product = service.getProduct(formGroup) as any;

        expect(product).toMatchObject({});
      });

      it('should return IProduct', () => {
        const formGroup = service.createProductFormGroup(sampleWithRequiredData);

        const product = service.getProduct(formGroup) as any;

        expect(product).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IProduct should not enable id FormControl', () => {
        const formGroup = service.createProductFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewProduct should disable id FormControl', () => {
        const formGroup = service.createProductFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});

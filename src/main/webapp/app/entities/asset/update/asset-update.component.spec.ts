import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject, from } from 'rxjs';

import { IAssetType } from 'app/entities/asset-type/asset-type.model';
import { AssetTypeService } from 'app/entities/asset-type/service/asset-type.service';
import { IRawAssetProcTmp } from 'app/entities/raw-asset-proc-tmp/raw-asset-proc-tmp.model';
import { RawAssetProcTmpService } from 'app/entities/raw-asset-proc-tmp/service/raw-asset-proc-tmp.service';
import { IAssetCollection } from 'app/entities/asset-collection/asset-collection.model';
import { AssetCollectionService } from 'app/entities/asset-collection/service/asset-collection.service';
import { IAsset } from '../asset.model';
import { AssetService } from '../service/asset.service';
import { AssetFormService } from './asset-form.service';

import { AssetUpdateComponent } from './asset-update.component';

describe('Asset Management Update Component', () => {
  let comp: AssetUpdateComponent;
  let fixture: ComponentFixture<AssetUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let assetFormService: AssetFormService;
  let assetService: AssetService;
  let assetTypeService: AssetTypeService;
  let rawAssetProcTmpService: RawAssetProcTmpService;
  let assetCollectionService: AssetCollectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, AssetUpdateComponent],
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
      .overrideTemplate(AssetUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(AssetUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    assetFormService = TestBed.inject(AssetFormService);
    assetService = TestBed.inject(AssetService);
    assetTypeService = TestBed.inject(AssetTypeService);
    rawAssetProcTmpService = TestBed.inject(RawAssetProcTmpService);
    assetCollectionService = TestBed.inject(AssetCollectionService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call AssetType query and add missing value', () => {
      const asset: IAsset = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
      const assetType: IAssetType = { id: 28246 };
      asset.assetType = assetType;

      const assetTypeCollection: IAssetType[] = [{ id: 27239 }];
      jest.spyOn(assetTypeService, 'query').mockReturnValue(of(new HttpResponse({ body: assetTypeCollection })));
      const additionalAssetTypes = [assetType];
      const expectedCollection: IAssetType[] = [...additionalAssetTypes, ...assetTypeCollection];
      jest.spyOn(assetTypeService, 'addAssetTypeToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      expect(assetTypeService.query).toHaveBeenCalled();
      expect(assetTypeService.addAssetTypeToCollectionIfMissing).toHaveBeenCalledWith(
        assetTypeCollection,
        ...additionalAssetTypes.map(expect.objectContaining),
      );
      expect(comp.assetTypesSharedCollection).toEqual(expectedCollection);
    });

    it('Should call RawAssetProcTmp query and add missing value', () => {
      const asset: IAsset = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
      const rawAssetProcTmp: IRawAssetProcTmp = { id: 20545 };
      asset.rawAssetProcTmp = rawAssetProcTmp;

      const rawAssetProcTmpCollection: IRawAssetProcTmp[] = [{ id: 9198 }];
      jest.spyOn(rawAssetProcTmpService, 'query').mockReturnValue(of(new HttpResponse({ body: rawAssetProcTmpCollection })));
      const additionalRawAssetProcTmps = [rawAssetProcTmp];
      const expectedCollection: IRawAssetProcTmp[] = [...additionalRawAssetProcTmps, ...rawAssetProcTmpCollection];
      jest.spyOn(rawAssetProcTmpService, 'addRawAssetProcTmpToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      expect(rawAssetProcTmpService.query).toHaveBeenCalled();
      expect(rawAssetProcTmpService.addRawAssetProcTmpToCollectionIfMissing).toHaveBeenCalledWith(
        rawAssetProcTmpCollection,
        ...additionalRawAssetProcTmps.map(expect.objectContaining),
      );
      expect(comp.rawAssetProcTmpsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call AssetCollection query and add missing value', () => {
      const asset: IAsset = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
      const assetCollections: IAssetCollection[] = [{ id: 18145 }];
      asset.assetCollections = assetCollections;

      const assetCollectionCollection: IAssetCollection[] = [{ id: 24874 }];
      jest.spyOn(assetCollectionService, 'query').mockReturnValue(of(new HttpResponse({ body: assetCollectionCollection })));
      const additionalAssetCollections = [...assetCollections];
      const expectedCollection: IAssetCollection[] = [...additionalAssetCollections, ...assetCollectionCollection];
      jest.spyOn(assetCollectionService, 'addAssetCollectionToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      expect(assetCollectionService.query).toHaveBeenCalled();
      expect(assetCollectionService.addAssetCollectionToCollectionIfMissing).toHaveBeenCalledWith(
        assetCollectionCollection,
        ...additionalAssetCollections.map(expect.objectContaining),
      );
      expect(comp.assetCollectionsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const asset: IAsset = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
      const assetType: IAssetType = { id: 30511 };
      asset.assetType = assetType;
      const rawAssetProcTmp: IRawAssetProcTmp = { id: 19785 };
      asset.rawAssetProcTmp = rawAssetProcTmp;
      const assetCollection: IAssetCollection = { id: 30728 };
      asset.assetCollections = [assetCollection];

      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      expect(comp.assetTypesSharedCollection).toContain(assetType);
      expect(comp.rawAssetProcTmpsSharedCollection).toContain(rawAssetProcTmp);
      expect(comp.assetCollectionsSharedCollection).toContain(assetCollection);
      expect(comp.asset).toEqual(asset);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAsset>>();
      const asset = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
      jest.spyOn(assetFormService, 'getAsset').mockReturnValue(asset);
      jest.spyOn(assetService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: asset }));
      saveSubject.complete();

      // THEN
      expect(assetFormService.getAsset).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(assetService.update).toHaveBeenCalledWith(expect.objectContaining(asset));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAsset>>();
      const asset = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
      jest.spyOn(assetFormService, 'getAsset').mockReturnValue({ id: null });
      jest.spyOn(assetService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ asset: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: asset }));
      saveSubject.complete();

      // THEN
      expect(assetFormService.getAsset).toHaveBeenCalled();
      expect(assetService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAsset>>();
      const asset = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
      jest.spyOn(assetService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ asset });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(assetService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareAssetType', () => {
      it('Should forward to assetTypeService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(assetTypeService, 'compareAssetType');
        comp.compareAssetType(entity, entity2);
        expect(assetTypeService.compareAssetType).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareRawAssetProcTmp', () => {
      it('Should forward to rawAssetProcTmpService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(rawAssetProcTmpService, 'compareRawAssetProcTmp');
        comp.compareRawAssetProcTmp(entity, entity2);
        expect(rawAssetProcTmpService.compareRawAssetProcTmp).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareAssetCollection', () => {
      it('Should forward to assetCollectionService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(assetCollectionService, 'compareAssetCollection');
        comp.compareAssetCollection(entity, entity2);
        expect(assetCollectionService.compareAssetCollection).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});

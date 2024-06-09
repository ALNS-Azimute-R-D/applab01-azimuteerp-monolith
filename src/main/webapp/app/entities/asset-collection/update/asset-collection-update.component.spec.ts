import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject, from } from 'rxjs';

import { IAsset } from 'app/entities/asset/asset.model';
import { AssetService } from 'app/entities/asset/service/asset.service';
import { IArticle } from 'app/entities/article/article.model';
import { ArticleService } from 'app/entities/article/service/article.service';
import { IAssetCollection } from '../asset-collection.model';
import { AssetCollectionService } from '../service/asset-collection.service';
import { AssetCollectionFormService } from './asset-collection-form.service';

import { AssetCollectionUpdateComponent } from './asset-collection-update.component';

describe('AssetCollection Management Update Component', () => {
  let comp: AssetCollectionUpdateComponent;
  let fixture: ComponentFixture<AssetCollectionUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let assetCollectionFormService: AssetCollectionFormService;
  let assetCollectionService: AssetCollectionService;
  let assetService: AssetService;
  let articleService: ArticleService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, AssetCollectionUpdateComponent],
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
      .overrideTemplate(AssetCollectionUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(AssetCollectionUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    assetCollectionFormService = TestBed.inject(AssetCollectionFormService);
    assetCollectionService = TestBed.inject(AssetCollectionService);
    assetService = TestBed.inject(AssetService);
    articleService = TestBed.inject(ArticleService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Asset query and add missing value', () => {
      const assetCollection: IAssetCollection = { id: 456 };
      const assets: IAsset[] = [{ id: 'd8dbcf06-04a1-481a-b77f-d1f8b7d987f2' }];
      assetCollection.assets = assets;

      const assetCollection: IAsset[] = [{ id: 'b58ab2cd-903c-4868-b0f1-5c348796ffb3' }];
      jest.spyOn(assetService, 'query').mockReturnValue(of(new HttpResponse({ body: assetCollection })));
      const additionalAssets = [...assets];
      const expectedCollection: IAsset[] = [...additionalAssets, ...assetCollection];
      jest.spyOn(assetService, 'addAssetToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ assetCollection });
      comp.ngOnInit();

      expect(assetService.query).toHaveBeenCalled();
      expect(assetService.addAssetToCollectionIfMissing).toHaveBeenCalledWith(
        assetCollection,
        ...additionalAssets.map(expect.objectContaining),
      );
      expect(comp.assetsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Article query and add missing value', () => {
      const assetCollection: IAssetCollection = { id: 456 };
      const articles: IArticle[] = [{ id: 4156 }];
      assetCollection.articles = articles;

      const articleCollection: IArticle[] = [{ id: 27978 }];
      jest.spyOn(articleService, 'query').mockReturnValue(of(new HttpResponse({ body: articleCollection })));
      const additionalArticles = [...articles];
      const expectedCollection: IArticle[] = [...additionalArticles, ...articleCollection];
      jest.spyOn(articleService, 'addArticleToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ assetCollection });
      comp.ngOnInit();

      expect(articleService.query).toHaveBeenCalled();
      expect(articleService.addArticleToCollectionIfMissing).toHaveBeenCalledWith(
        articleCollection,
        ...additionalArticles.map(expect.objectContaining),
      );
      expect(comp.articlesSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const assetCollection: IAssetCollection = { id: 456 };
      const asset: IAsset = { id: '15009df4-5406-4cde-9a45-24404b46ca39' };
      assetCollection.assets = [asset];
      const article: IArticle = { id: 24178 };
      assetCollection.articles = [article];

      activatedRoute.data = of({ assetCollection });
      comp.ngOnInit();

      expect(comp.assetsSharedCollection).toContain(asset);
      expect(comp.articlesSharedCollection).toContain(article);
      expect(comp.assetCollection).toEqual(assetCollection);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAssetCollection>>();
      const assetCollection = { id: 123 };
      jest.spyOn(assetCollectionFormService, 'getAssetCollection').mockReturnValue(assetCollection);
      jest.spyOn(assetCollectionService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ assetCollection });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: assetCollection }));
      saveSubject.complete();

      // THEN
      expect(assetCollectionFormService.getAssetCollection).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(assetCollectionService.update).toHaveBeenCalledWith(expect.objectContaining(assetCollection));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAssetCollection>>();
      const assetCollection = { id: 123 };
      jest.spyOn(assetCollectionFormService, 'getAssetCollection').mockReturnValue({ id: null });
      jest.spyOn(assetCollectionService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ assetCollection: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: assetCollection }));
      saveSubject.complete();

      // THEN
      expect(assetCollectionFormService.getAssetCollection).toHaveBeenCalled();
      expect(assetCollectionService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IAssetCollection>>();
      const assetCollection = { id: 123 };
      jest.spyOn(assetCollectionService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ assetCollection });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(assetCollectionService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareAsset', () => {
      it('Should forward to assetService', () => {
        const entity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        const entity2 = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
        jest.spyOn(assetService, 'compareAsset');
        comp.compareAsset(entity, entity2);
        expect(assetService.compareAsset).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareArticle', () => {
      it('Should forward to articleService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(articleService, 'compareArticle');
        comp.compareArticle(entity, entity2);
        expect(articleService.compareArticle).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});

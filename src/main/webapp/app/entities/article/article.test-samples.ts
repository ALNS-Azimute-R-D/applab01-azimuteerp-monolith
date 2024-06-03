import { IArticle, NewArticle } from './article.model';

export const sampleWithRequiredData: IArticle = {
  id: 4156,
  inventoryProductId: 27978,
  itemSize: 'XXL',
};

export const sampleWithPartialData: IArticle = {
  id: 30496,
  inventoryProductId: 4863,
  customName: 'furthermore apropos',
  customDescription: '../fake-data/blob/hipster.txt',
  itemSize: 'XL',
};

export const sampleWithFullData: IArticle = {
  id: 22977,
  inventoryProductId: 18200,
  customName: 'before',
  customDescription: '../fake-data/blob/hipster.txt',
  priceValue: 24991.54,
  itemSize: 'XXXL',
  assetsCollectionUUID: 'recall spiritual flush',
  isEnabled: false,
};

export const sampleWithNewData: NewArticle = {
  inventoryProductId: 21742,
  itemSize: 'XXXL',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

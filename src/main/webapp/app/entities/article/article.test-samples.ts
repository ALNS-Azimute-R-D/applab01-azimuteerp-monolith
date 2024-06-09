import { IArticle, NewArticle } from './article.model';

export const sampleWithRequiredData: IArticle = {
  id: 3986,
  inventoryProductId: 15524,
  itemSize: 'XXL',
  activationStatus: 'BLOCKED',
};

export const sampleWithPartialData: IArticle = {
  id: 16451,
  inventoryProductId: 3126,
  customDescription: 'of merit',
  itemSize: 'M',
  activationStatus: 'INVALID',
};

export const sampleWithFullData: IArticle = {
  id: 18190,
  inventoryProductId: 12470,
  skuCode: 'rev',
  customName: 'hesitate overview',
  customDescription: 'warmhearted real',
  priceValue: 29947.64,
  itemSize: 'XXL',
  activationStatus: 'PENDENT',
};

export const sampleWithNewData: NewArticle = {
  inventoryProductId: 25841,
  itemSize: 'XXXL',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

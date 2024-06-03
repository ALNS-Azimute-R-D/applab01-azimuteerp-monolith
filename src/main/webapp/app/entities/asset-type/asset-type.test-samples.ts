import { IAssetType, NewAssetType } from './asset-type.model';

export const sampleWithRequiredData: IAssetType = {
  id: 16556,
  name: 'beetle into quickly',
};

export const sampleWithPartialData: IAssetType = {
  id: 13162,
  acronym: 'rail',
  name: 'gosh',
  handlerClazzName: 'till unless',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IAssetType = {
  id: 25171,
  acronym: 'lumber out caffeine',
  name: 'captor throughout toward',
  description: 'lest particularize',
  handlerClazzName: 'unlike',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewAssetType = {
  name: 'consult phew oily',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

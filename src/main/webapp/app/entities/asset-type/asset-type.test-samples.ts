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
  customAttributesDetailsJSON: 'crook attest elegantly',
};

export const sampleWithFullData: IAssetType = {
  id: 3938,
  acronym: 'captor throughout toward',
  name: 'lest particularize',
  description: 'unlike',
  handlerClazzName: 'consult phew oily',
  customAttributesDetailsJSON: 'phooey',
};

export const sampleWithNewData: NewAssetType = {
  name: 'what',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

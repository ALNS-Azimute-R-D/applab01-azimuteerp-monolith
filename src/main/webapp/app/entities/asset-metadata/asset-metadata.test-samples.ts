import { IAssetMetadata, NewAssetMetadata } from './asset-metadata.model';

export const sampleWithRequiredData: IAssetMetadata = {
  id: 26508,
};

export const sampleWithPartialData: IAssetMetadata = {
  id: 23722,
};

export const sampleWithFullData: IAssetMetadata = {
  id: 17046,
  metadataDetailsJSON: 'until frown behoove',
};

export const sampleWithNewData: NewAssetMetadata = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

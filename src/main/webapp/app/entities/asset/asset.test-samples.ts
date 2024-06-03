import { IAsset, NewAsset } from './asset.model';

export const sampleWithRequiredData: IAsset = {
  id: 29832,
  name: 'monthly dramatic gadzooks',
};

export const sampleWithPartialData: IAsset = {
  id: 12437,
  uid: '5369c8a7-b6fe-4b2b-ac44-251f0baf5e98',
  name: 'inasmuch tremendously',
  storageTypeUsed: 'REMOTE_FILESYSTEM',
  status: 'ENABLED',
  preferredPurpose: 'PHOTO_ALBUM',
};

export const sampleWithFullData: IAsset = {
  id: 23533,
  uid: '7c7dbdd1-294a-4a0c-9853-6a58d2d08022',
  name: 'ick sadly',
  storageTypeUsed: 'OTHER_CLOUD_STORAGE',
  fullFilenamePath: 'riffle psst',
  status: 'DISABLED',
  preferredPurpose: 'OTHER',
  assetContentAsBlob: '../fake-data/blob/hipster.png',
  assetContentAsBlobContentType: 'unknown',
};

export const sampleWithNewData: NewAsset = {
  name: 'open squid',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

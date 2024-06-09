import { IRawAssetProcTmp, NewRawAssetProcTmp } from './raw-asset-proc-tmp.model';

export const sampleWithRequiredData: IRawAssetProcTmp = {
  id: 5587,
  name: 'fitting especially sleek',
};

export const sampleWithPartialData: IRawAssetProcTmp = {
  id: 10108,
  name: 'freely',
  fullFilenamePath: 'helpful',
  assetRawContentAsBlob: '../fake-data/blob/hipster.png',
  assetRawContentAsBlobContentType: 'unknown',
};

export const sampleWithFullData: IRawAssetProcTmp = {
  id: 19519,
  name: 'opposite',
  statusRawProcessing: 'UPLOADING',
  fullFilenamePath: 'referendum regarding manicure',
  assetRawContentAsBlob: '../fake-data/blob/hipster.png',
  assetRawContentAsBlobContentType: 'unknown',
  customAttributesDetailsJSON: 'whoever er gee',
};

export const sampleWithNewData: NewRawAssetProcTmp = {
  name: 'wither',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

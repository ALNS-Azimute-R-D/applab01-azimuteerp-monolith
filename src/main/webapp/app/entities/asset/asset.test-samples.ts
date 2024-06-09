import { IAsset, NewAsset } from './asset.model';

export const sampleWithRequiredData: IAsset = {
  id: 'eee19117-7f95-4efe-93b3-33c8a73f4686',
  name: 'safely',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IAsset = {
  id: 'c44251f0-baf5-4e98-b983-c37945b7ef56',
  name: 'string if',
  preferredPurpose: 'ANY_OFFICE_FILE_TYPE',
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: IAsset = {
  id: '0c8536a5-8d2d-4080-b224-8bd17e1e1778',
  name: 'surround braai',
  storageTypeUsed: 'AWS_S3',
  fullFilenamePath: 'unless ew ill',
  status: 'ENABLED',
  preferredPurpose: 'EXECUTABLE_PROGRAM_BINARY',
  assetContentAsBlob: '../fake-data/blob/hipster.png',
  assetContentAsBlobContentType: 'unknown',
  activationStatus: 'INVALID',
};

export const sampleWithNewData: NewAsset = {
  name: 'however apropos gosh',
  activationStatus: 'ON_HOLD',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

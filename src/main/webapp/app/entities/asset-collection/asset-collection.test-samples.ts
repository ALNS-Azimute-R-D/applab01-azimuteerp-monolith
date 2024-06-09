import { IAssetCollection, NewAssetCollection } from './asset-collection.model';

export const sampleWithRequiredData: IAssetCollection = {
  id: 24625,
  name: 'hassle turbulent sunlamp',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IAssetCollection = {
  id: 22811,
  name: 'abnegate',
  activationStatus: 'ACTIVE',
};

export const sampleWithFullData: IAssetCollection = {
  id: 20139,
  name: 'since',
  fullFilenamePath: 'damp nervously basics',
  activationStatus: 'PENDENT',
};

export const sampleWithNewData: NewAssetCollection = {
  name: 'meh',
  activationStatus: 'ON_HOLD',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

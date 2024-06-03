import { IBusinessUnit, NewBusinessUnit } from './business-unit.model';

export const sampleWithRequiredData: IBusinessUnit = {
  id: 26240,
  acronym: 'even downright after',
  name: 'ha',
  activationStatus: 'ACTIVE',
};

export const sampleWithPartialData: IBusinessUnit = {
  id: 3463,
  acronym: 'excerpt',
  name: 'worriedly',
  activationStatus: 'INACTIVE',
};

export const sampleWithFullData: IBusinessUnit = {
  id: 8227,
  acronym: 'nor collagen blah',
  hierarchicalLevel: 'direct judgementally',
  name: 'nutritious while lined',
  activationStatus: 'ACTIVE',
};

export const sampleWithNewData: NewBusinessUnit = {
  acronym: 'buckwheat though',
  name: 'sty when weakly',
  activationStatus: 'BLOCKED',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

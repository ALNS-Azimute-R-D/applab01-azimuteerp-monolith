import { IBrand, NewBrand } from './brand.model';

export const sampleWithRequiredData: IBrand = {
  id: 1105,
  acronym: 'sea',
  name: 'finally following gaseous',
};

export const sampleWithPartialData: IBrand = {
  id: 9085,
  acronym: 'exposure powerful ac',
  name: 'yet',
  description: 'anti',
  logoBrand: '../fake-data/blob/hipster.png',
  logoBrandContentType: 'unknown',
};

export const sampleWithFullData: IBrand = {
  id: 26658,
  acronym: 'nor scratchy made-up',
  name: 'shelter impure',
  description: 'salsa',
  logoBrand: '../fake-data/blob/hipster.png',
  logoBrandContentType: 'unknown',
};

export const sampleWithNewData: NewBrand = {
  acronym: 'exterminate',
  name: 'caramelize',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

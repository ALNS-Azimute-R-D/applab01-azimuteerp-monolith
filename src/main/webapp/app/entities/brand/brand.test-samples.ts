import { IBrand, NewBrand } from './brand.model';

export const sampleWithRequiredData: IBrand = {
  id: 25485,
  acronym: 'mmm',
  name: 'jam despite slight',
};

export const sampleWithPartialData: IBrand = {
  id: 4316,
  acronym: 'archeology',
  name: 'unique even',
  description: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IBrand = {
  id: 350,
  acronym: 'yet',
  name: 'anti',
  description: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewBrand = {
  acronym: 'supposing throb whim',
  name: 'than phew',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

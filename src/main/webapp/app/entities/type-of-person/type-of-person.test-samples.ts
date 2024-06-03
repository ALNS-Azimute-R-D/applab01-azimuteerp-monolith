import { ITypeOfPerson, NewTypeOfPerson } from './type-of-person.model';

export const sampleWithRequiredData: ITypeOfPerson = {
  id: 20304,
  code: 'where',
  description: 'promptly reluctantly neuron',
};

export const sampleWithPartialData: ITypeOfPerson = {
  id: 20479,
  code: 'chale',
  description: 'phew wrong',
};

export const sampleWithFullData: ITypeOfPerson = {
  id: 2925,
  code: 'brr m',
  description: 'queasily',
};

export const sampleWithNewData: NewTypeOfPerson = {
  code: 'easil',
  description: 'nearly puppet',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

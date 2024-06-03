import { ICustomerType, NewCustomerType } from './customer-type.model';

export const sampleWithRequiredData: ICustomerType = {
  id: 14267,
  name: 'eke',
};

export const sampleWithPartialData: ICustomerType = {
  id: 3417,
  name: 'track brr the',
  description: 'knot',
  businessHandlerClazz: 'between now',
};

export const sampleWithFullData: ICustomerType = {
  id: 17371,
  name: 'raven weary separate',
  description: 'hmph',
  businessHandlerClazz: 'perpetrate whoa',
};

export const sampleWithNewData: NewCustomerType = {
  name: 'whoever',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

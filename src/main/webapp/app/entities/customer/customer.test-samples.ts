import { ICustomer, NewCustomer } from './customer.model';

export const sampleWithRequiredData: ICustomer = {
  id: 31159,
  customerBusinessCode: 'youthfully ew a',
  fullname: 'boo as',
  customerStatus: 'WORKING',
  activationStatus: 'PENDENT',
};

export const sampleWithPartialData: ICustomer = {
  id: 16793,
  customerBusinessCode: 'pfft since',
  fullname: 'percolate',
  customAttributesDetailsJSON: 'ew',
  customerStatus: 'IN_FAILURE',
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: ICustomer = {
  id: 11643,
  customerBusinessCode: 'upright yuck',
  fullname: 'blanch hood',
  customAttributesDetailsJSON: 'on',
  customerStatus: 'IN_FAILURE',
  activationStatus: 'ACTIVE',
};

export const sampleWithNewData: NewCustomer = {
  customerBusinessCode: 'hmph ironclad t',
  fullname: 'onto kaleidoscopic',
  customerStatus: 'PENDENT',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

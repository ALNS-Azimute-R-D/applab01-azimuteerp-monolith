import { ICustomer, NewCustomer } from './customer.model';

export const sampleWithRequiredData: ICustomer = {
  id: 13376,
  customerBusinessCode: 'as',
  name: 'oof jubilantly',
  email: '6qU.h@u.At[8h$',
  status: 'IN_FAILURE',
  active: false,
};

export const sampleWithPartialData: ICustomer = {
  id: 25521,
  customerBusinessCode: 'demand evergree',
  name: 'slash',
  description: '../fake-data/blob/hipster.txt',
  email: 'j@Y-9zJ8.2d',
  addressDetails: 'where transparency',
  zipCode: '73774-69',
  status: 'ONBOARDING',
  active: true,
};

export const sampleWithFullData: ICustomer = {
  id: 26748,
  customerBusinessCode: 'onto kaleidosco',
  name: 'flat milk ignite',
  description: '../fake-data/blob/hipster.txt',
  email: ',Qz@]JtK4.%.1Iu',
  addressDetails: 'impudence frosty down',
  zipCode: '30613-93',
  keycloakGroupDetails: 'befog enact',
  status: 'ONBOARDING',
  active: true,
};

export const sampleWithNewData: NewCustomer = {
  customerBusinessCode: 'until across kn',
  name: 'athwart plain pfft',
  email: '+Y?/@EM.Pls5lW',
  status: 'WORKING',
  active: true,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

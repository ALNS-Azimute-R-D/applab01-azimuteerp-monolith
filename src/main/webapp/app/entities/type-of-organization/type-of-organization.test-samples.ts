import { ITypeOfOrganization, NewTypeOfOrganization } from './type-of-organization.model';

export const sampleWithRequiredData: ITypeOfOrganization = {
  id: 3809,
  acronym: 'likewise casserole p',
  name: 'slimy lope',
  description: '../fake-data/blob/hipster.txt',
};

export const sampleWithPartialData: ITypeOfOrganization = {
  id: 986,
  acronym: 'lasso',
  name: 'photoshop',
  description: '../fake-data/blob/hipster.txt',
  businessHandlerClazz: 'lively bloom',
};

export const sampleWithFullData: ITypeOfOrganization = {
  id: 26215,
  acronym: 'instead',
  name: 'from meh',
  description: '../fake-data/blob/hipster.txt',
  businessHandlerClazz: 'drool venerated',
};

export const sampleWithNewData: NewTypeOfOrganization = {
  acronym: 'to blank fossilise',
  name: 'commonly',
  description: '../fake-data/blob/hipster.txt',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

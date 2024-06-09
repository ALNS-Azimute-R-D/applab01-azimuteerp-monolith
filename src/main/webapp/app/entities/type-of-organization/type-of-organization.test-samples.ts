import { ITypeOfOrganization, NewTypeOfOrganization } from './type-of-organization.model';

export const sampleWithRequiredData: ITypeOfOrganization = {
  id: 3809,
  acronym: 'likewise casserole p',
  name: 'slimy lope',
  description: 'furthermore',
};

export const sampleWithPartialData: ITypeOfOrganization = {
  id: 16059,
  acronym: 'photoshop',
  name: 'lively bloom',
  description: 'puzzle screamer gadzooks',
};

export const sampleWithFullData: ITypeOfOrganization = {
  id: 4647,
  acronym: 'mostly rotating',
  name: 'grave reconsideration or',
  description: 'bleak beside',
  businessHandlerClazz: 'behind joshingly phew',
};

export const sampleWithNewData: NewTypeOfOrganization = {
  acronym: 'airship',
  name: 'cramp',
  description: 'sympathetically',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

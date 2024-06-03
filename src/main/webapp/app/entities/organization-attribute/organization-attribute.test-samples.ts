import { IOrganizationAttribute, NewOrganizationAttribute } from './organization-attribute.model';

export const sampleWithRequiredData: IOrganizationAttribute = {
  id: 22708,
};

export const sampleWithPartialData: IOrganizationAttribute = {
  id: 13902,
  attributeValue: 'whose as pile',
};

export const sampleWithFullData: IOrganizationAttribute = {
  id: 11108,
  attributeName: 'spotless',
  attributeValue: 'intestine',
};

export const sampleWithNewData: NewOrganizationAttribute = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

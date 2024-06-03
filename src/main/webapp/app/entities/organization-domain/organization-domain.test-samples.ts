import { IOrganizationDomain, NewOrganizationDomain } from './organization-domain.model';

export const sampleWithRequiredData: IOrganizationDomain = {
  id: 24598,
  domainAcronym: 'shakily search',
  name: 'easily',
  isVerified: false,
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IOrganizationDomain = {
  id: 21201,
  domainAcronym: 'rude as',
  name: 'jaggedly commonly',
  isVerified: false,
  activationStatus: 'PENDENT',
};

export const sampleWithFullData: IOrganizationDomain = {
  id: 7299,
  domainAcronym: 'striped',
  name: 'flex',
  isVerified: true,
  businessHandlerClazz: 'cactus',
  activationStatus: 'ACTIVE',
};

export const sampleWithNewData: NewOrganizationDomain = {
  domainAcronym: 'irritably throughout poorly',
  name: 'plush since below',
  isVerified: false,
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

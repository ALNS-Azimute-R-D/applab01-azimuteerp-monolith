import { IOrganization, NewOrganization } from './organization.model';

export const sampleWithRequiredData: IOrganization = {
  id: 16855,
  acronym: 'boost accordion elve',
  businessCode: 'manacle shuffle',
  name: 'ack if',
  description: 'gather',
  organizationStatus: 'WORKING',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IOrganization = {
  id: 2113,
  acronym: 'unfit voyage',
  businessCode: 'applause',
  hierarchicalLevel: 'ugh inasmuch',
  name: 'wetly whoa',
  description: 'cuss fatally instantly',
  businessHandlerClazz: 'duh lonely',
  technicalEnvironmentsDetailsJSON: 'midst unlawful how',
  customAttributesDetailsJSON: 'rotten',
  organizationStatus: 'IN_FAILURE',
  activationStatus: 'INVALID',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
};

export const sampleWithFullData: IOrganization = {
  id: 13698,
  acronym: 'productive gray hmph',
  businessCode: 'impound unexpec',
  hierarchicalLevel: 'deliberately',
  name: 'continually indeed since',
  description: 'once',
  businessHandlerClazz: 'collapse forenenst',
  mainContactPersonDetailsJSON: 'often diam',
  technicalEnvironmentsDetailsJSON: 'ick longingly undertake',
  customAttributesDetailsJSON: 'pudding bravely finally',
  organizationStatus: 'IN_FAILURE',
  activationStatus: 'ON_HOLD',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
};

export const sampleWithNewData: NewOrganization = {
  acronym: 'brisk',
  businessCode: 'vainly',
  name: 'into',
  description: 'familiarize above',
  organizationStatus: 'ONBOARDING',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

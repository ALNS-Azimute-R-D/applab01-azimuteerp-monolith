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
  technicalEnvironmentsDetails: '../fake-data/blob/hipster.txt',
  commonCustomAttributesDetails: '../fake-data/blob/hipster.txt',
  organizationStatus: 'IN_FAILURE',
  activationStatus: 'PENDENT',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
};

export const sampleWithFullData: IOrganization = {
  id: 741,
  acronym: 'not whoever',
  businessCode: 'phew',
  hierarchicalLevel: 'yawningly productive',
  name: 'sharply ping',
  description: 'macaw chick',
  businessHandlerClazz: 'tightly continually',
  mainContactPersonDetails: '../fake-data/blob/hipster.txt',
  technicalEnvironmentsDetails: '../fake-data/blob/hipster.txt',
  commonCustomAttributesDetails: '../fake-data/blob/hipster.txt',
  organizationStatus: 'WORKING',
  activationStatus: 'PENDENT',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
};

export const sampleWithNewData: NewOrganization = {
  acronym: 'pish midst with',
  businessCode: 'uh-huh',
  name: 'vote',
  description: 'broadly pish',
  organizationStatus: 'UNDER_EVALUATION',
  activationStatus: 'INACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

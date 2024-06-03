import { ITenant, NewTenant } from './tenant.model';

export const sampleWithRequiredData: ITenant = {
  id: 25198,
  acronym: 'desk',
  name: 'bah unless',
  description: 'gazebo failing around',
  customerBusinessCode: 'oh tummy or',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: ITenant = {
  id: 15539,
  acronym: 'safely sarcastic apu',
  name: 'round in impropriety',
  description: 'cigarette',
  customerBusinessCode: 'fortunately ant',
  businessHandlerClazz: 'whereas',
  billingDetails: '../fake-data/blob/hipster.txt',
  technicalEnvironmentsDetails: '../fake-data/blob/hipster.txt',
  commonCustomAttributesDetails: '../fake-data/blob/hipster.txt',
  activationStatus: 'PENDENT',
};

export const sampleWithFullData: ITenant = {
  id: 12159,
  acronym: 'fowl muted',
  name: 'pfft like potentially',
  description: 'yahoo',
  customerBusinessCode: 'putter',
  businessHandlerClazz: 'comfortable willow unwitting',
  mainContactPersonDetails: '../fake-data/blob/hipster.txt',
  billingDetails: '../fake-data/blob/hipster.txt',
  technicalEnvironmentsDetails: '../fake-data/blob/hipster.txt',
  commonCustomAttributesDetails: '../fake-data/blob/hipster.txt',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
  activationStatus: 'ON_HOLD',
};

export const sampleWithNewData: NewTenant = {
  acronym: 'blister whoever till',
  name: 'sans',
  description: 'capital phew',
  customerBusinessCode: 'abaft gladly',
  activationStatus: 'PENDENT',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

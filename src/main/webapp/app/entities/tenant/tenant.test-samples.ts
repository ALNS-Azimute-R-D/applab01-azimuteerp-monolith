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
  billingDetailsJSON: 'within remote',
  technicalEnvironmentsDetailsJSON: 'walker phooey stake',
  customAttributesDetailsJSON: 'every',
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: ITenant = {
  id: 12393,
  acronym: 'putter',
  name: 'comfortable willow unwitting',
  description: 'separately apud',
  customerBusinessCode: 'till deprive re',
  businessHandlerClazz: 'until psst why',
  mainContactPersonDetailsJSON: 'doorway',
  billingDetailsJSON: 'distinct under but',
  technicalEnvironmentsDetailsJSON: 'though best',
  customAttributesDetailsJSON: 'because shyly provided',
  logoImg: '../fake-data/blob/hipster.png',
  logoImgContentType: 'unknown',
  activationStatus: 'BLOCKED',
};

export const sampleWithNewData: NewTenant = {
  acronym: 'until geez',
  name: 'sizzling unused',
  description: 'output till near',
  customerBusinessCode: 'portfolio onto',
  activationStatus: 'INVALID',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

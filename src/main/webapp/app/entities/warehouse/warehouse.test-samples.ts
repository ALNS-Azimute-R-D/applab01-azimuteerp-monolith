import { IWarehouse, NewWarehouse } from './warehouse.model';

export const sampleWithRequiredData: IWarehouse = {
  id: 758,
  acronym: 'meh',
  name: 'charm rightfully incidentally',
  streetAddress: 'rubbery',
  postalCode: 'tense',
  activationStatus: 'INVALID',
};

export const sampleWithPartialData: IWarehouse = {
  id: 18516,
  acronym: 'knottily farewell midst',
  name: 'crumble ack',
  description: 'loosely',
  streetAddress: 'haircut boohoo',
  houseNumber: 'media',
  locationName: 'an gosh wherever',
  postalCode: 'upwardly ',
  mainEmail: 'I>@K.?',
  mobilePhoneNumber: 'gunpowder pish ',
  activationStatus: 'ACTIVE',
};

export const sampleWithFullData: IWarehouse = {
  id: 30030,
  acronym: 'revascularisation coordinate',
  name: 'bare',
  description: 'improvise smell reflate',
  streetAddress: 'preen strand',
  houseNumber: 'gosh stingy molar',
  locationName: 'impressionable whose',
  postalCode: 'at quizzi',
  pointLocation: '../fake-data/blob/hipster.png',
  pointLocationContentType: 'unknown',
  mainEmail: '#L+@w,KH.n',
  landPhoneNumber: 'standardize',
  mobilePhoneNumber: 'characterize pr',
  faxNumber: 'like mid while',
  customAttributesDetailsJSON: 'phooey',
  activationStatus: 'INVALID',
};

export const sampleWithNewData: NewWarehouse = {
  acronym: 'negative',
  name: 'fooey zigzag fossilize',
  streetAddress: 'prudent balalaika between',
  postalCode: 'deepen',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

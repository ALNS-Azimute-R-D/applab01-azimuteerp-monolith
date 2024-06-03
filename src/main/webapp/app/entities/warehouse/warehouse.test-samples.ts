import { IWarehouse, NewWarehouse } from './warehouse.model';

export const sampleWithRequiredData: IWarehouse = {
  id: 28499,
  acronym: 'tension',
  name: 'oh fruitful',
  streetAddress: 'incidentally rinse next',
  postalCode: 'although ',
};

export const sampleWithPartialData: IWarehouse = {
  id: 8017,
  acronym: 'perform nor',
  name: 'or hideous blah',
  streetAddress: 'of power',
  postalCode: 'integrate',
  pointLocation: '../fake-data/blob/hipster.png',
  pointLocationContentType: 'unknown',
  mainEmail: 'K@oR49z-.o]dv1',
  landPhoneNumber: 'everlasting ali',
  mobilePhoneNumber: 'incidentally di',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IWarehouse = {
  id: 23802,
  acronym: 'loosely ah',
  name: 'per',
  description: '../fake-data/blob/hipster.txt',
  streetAddress: 'manufacturer how',
  houseNumber: 'deal except cereal',
  locationName: 'since extradite including',
  postalCode: 'and soupy',
  pointLocation: '../fake-data/blob/hipster.png',
  pointLocationContentType: 'unknown',
  mainEmail: 'oaIc_B@+}zmF:.u~46Ph',
  landPhoneNumber: 'prioritize nor ',
  mobilePhoneNumber: 'sentimentalise ',
  faxNumber: 'finally unlike ',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewWarehouse = {
  acronym: 'for phew',
  name: 'kookily father excepting',
  streetAddress: 'during',
  postalCode: 'often exa',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

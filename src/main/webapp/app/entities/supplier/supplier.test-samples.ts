import { ISupplier, NewSupplier } from './supplier.model';

export const sampleWithRequiredData: ISupplier = {
  id: 22569,
  acronym: 'gently attraction',
  companyName: 'typify huzzah',
  streetAddress: 'justly unfolded',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: ISupplier = {
  id: 17439,
  acronym: 'beside er hypnotize',
  companyName: 'fortunately beneath',
  streetAddress: 'equal',
  zipPostalCode: 'eek vessel hove',
  countryRegion: 'rehome across jovially',
  phoneNumber1: 'while to',
  phoneNumber2: 'yieldingly wise',
  customAttributesDetailsJSON: 'yum',
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: ISupplier = {
  id: 23826,
  acronym: 'indeed',
  companyName: 'or',
  streetAddress: 'whether abbreviate',
  houseNumber: 'unlike consequently',
  locationName: 'vital',
  city: 'North Samaraton',
  stateProvince: 'eek between',
  zipPostalCode: 'aha sleepily in',
  countryRegion: 'politician successfully gadzooks',
  pointLocation: '../fake-data/blob/hipster.png',
  pointLocationContentType: 'unknown',
  mainEmail: 'CSv@"ej4.$*^1c',
  phoneNumber1: 'willfully',
  phoneNumber2: 'standardisation',
  customAttributesDetailsJSON: 'pitcher eminent',
  activationStatus: 'ON_HOLD',
};

export const sampleWithNewData: NewSupplier = {
  acronym: 'furthermore before near',
  companyName: 'beyond ick crusade',
  streetAddress: 'deliberately ouch',
  activationStatus: 'PENDENT',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

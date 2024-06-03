import { ISupplier, NewSupplier } from './supplier.model';

export const sampleWithRequiredData: ISupplier = {
  id: 26984,
  acronym: 'likewise cleave basil',
  companyName: 'phooey',
  streetAddress: 'worth utilized',
};

export const sampleWithPartialData: ISupplier = {
  id: 10167,
  acronym: 'atrium onto fortunately',
  companyName: 'deepen equal',
  representativeFirstName: 'eek vessel hovel',
  jobTitle: 'Legacy Marketing Designer',
  streetAddress: 'lavish provided service',
  city: 'Colorado Springs',
  stateProvince: 'scissors carbohydrate',
  zipPostalCode: 'outstanding',
  mainEmail: '|$5p2@b.=ne0',
  faxNumber: 'bafflement',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: ISupplier = {
  id: 21437,
  acronym: 'gadzooks right microwave',
  companyName: 'spherical embed',
  representativeLastName: 'bewitched expense ejector',
  representativeFirstName: 'breathalyze whose',
  jobTitle: 'Chief Usability Coordinator',
  streetAddress: 'incidentally overrun hastily',
  houseNumber: 'gadzooks randomizati',
  locationName: 'yuck cylindrical gigantic',
  city: 'North Judd',
  stateProvince: 'aha',
  zipPostalCode: 'skullduggery fu',
  countryRegion: 'steel',
  webPage: '../fake-data/blob/hipster.txt',
  pointLocation: '../fake-data/blob/hipster.png',
  pointLocationContentType: 'unknown',
  mainEmail: 'kA*~@Ap(.K',
  landPhoneNumber: 'scout rude dail',
  mobilePhoneNumber: 'ancient golden ',
  faxNumber: 'liquor',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewSupplier = {
  acronym: 'messenger how',
  companyName: 'shiny',
  streetAddress: 'hence',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

import { ICommonLocality, NewCommonLocality } from './common-locality.model';

export const sampleWithRequiredData: ICommonLocality = {
  id: 5639,
  acronym: 'following upright',
  name: 'even fooey',
  streetAddress: 'genre raiment overthrow',
  postalCode: 'guilty',
};

export const sampleWithPartialData: ICommonLocality = {
  id: 2219,
  acronym: 'concerned outside',
  name: 'lunge tightly',
  description: 'at bashfully next',
  streetAddress: 'drat duh',
  locationName: 'butcher instead uh-huh',
  postalCode: 'vicious f',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithFullData: ICommonLocality = {
  id: 18421,
  acronym: 'upliftingly yielding',
  name: 'whether',
  description: 'hourly',
  streetAddress: 'trachoma blindly',
  houseNumber: 'easy which sheepishl',
  locationName: 'average incidentally psst',
  postalCode: 'ick suppo',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewCommonLocality = {
  acronym: 'modulo blindfold',
  name: 'since excluding athwart',
  streetAddress: 'racer promptly hence',
  postalCode: 'fabulous ',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

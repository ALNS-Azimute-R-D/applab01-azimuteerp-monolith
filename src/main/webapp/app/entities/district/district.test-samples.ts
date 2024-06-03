import { IDistrict, NewDistrict } from './district.model';

export const sampleWithRequiredData: IDistrict = {
  id: 6953,
  acronym: 'blunder ',
  name: 'oh',
};

export const sampleWithPartialData: IDistrict = {
  id: 29891,
  acronym: 'white pr',
  name: 'color under next',
};

export const sampleWithFullData: IDistrict = {
  id: 20304,
  acronym: 'furiousl',
  name: 'bleakly brr',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewDistrict = {
  acronym: 'plaintiv',
  name: 'digitise however awkwardly',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

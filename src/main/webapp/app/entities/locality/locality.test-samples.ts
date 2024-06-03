import { ILocality, NewLocality } from './locality.model';

export const sampleWithRequiredData: ILocality = {
  id: 24048,
  acronym: 'apropos ',
  name: 'dry',
};

export const sampleWithPartialData: ILocality = {
  id: 29539,
  acronym: 'around',
  name: 'mile',
};

export const sampleWithFullData: ILocality = {
  id: 14145,
  acronym: 'equal',
  name: 'third',
  description: '../fake-data/blob/hipster.txt',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewLocality = {
  acronym: 'through',
  name: 'shakily access hence',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

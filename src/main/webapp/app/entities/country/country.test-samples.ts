import { ICountry, NewCountry } from './country.model';

export const sampleWithRequiredData: ICountry = {
  id: 15941,
  acronym: 'tre',
  name: 'fervently worth patrol',
  continent: 'NORTH_AMERICA',
};

export const sampleWithPartialData: ICountry = {
  id: 1910,
  acronym: 'acc',
  name: 'whoa dreamily authorization',
  continent: 'EUROPE',
};

export const sampleWithFullData: ICountry = {
  id: 22899,
  acronym: 'boo',
  name: 'object',
  continent: 'CENTRAL_AMERICA',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewCountry = {
  acronym: 'int',
  name: 'neglected voluminous',
  continent: 'EUROPE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

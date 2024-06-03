import { ITownCity, NewTownCity } from './town-city.model';

export const sampleWithRequiredData: ITownCity = {
  id: 29331,
  acronym: 'sympathe',
  name: 'down after',
};

export const sampleWithPartialData: ITownCity = {
  id: 27294,
  acronym: 'housing',
  name: 'eek monasticism',
};

export const sampleWithFullData: ITownCity = {
  id: 14202,
  acronym: 'greedily',
  name: 'adorable',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewTownCity = {
  acronym: 'how thic',
  name: 'valiantly monthly connive',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

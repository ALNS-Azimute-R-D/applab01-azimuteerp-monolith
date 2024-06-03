import { IProvince, NewProvince } from './province.model';

export const sampleWithRequiredData: IProvince = {
  id: 27131,
  acronym: 'wei',
  name: 'ophthalmologist since',
};

export const sampleWithPartialData: IProvince = {
  id: 19154,
  acronym: 'gee',
  name: 'rivulet brown unnecessarily',
};

export const sampleWithFullData: IProvince = {
  id: 3249,
  acronym: 'hm',
  name: 'when pootle woozy',
  geoPolygonArea: '../fake-data/blob/hipster.png',
  geoPolygonAreaContentType: 'unknown',
};

export const sampleWithNewData: NewProvince = {
  acronym: 'dif',
  name: 'excluding',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

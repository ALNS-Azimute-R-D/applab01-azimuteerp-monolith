import dayjs from 'dayjs/esm';

import { IStockLevel, NewStockLevel } from './stock-level.model';

export const sampleWithRequiredData: IStockLevel = {
  id: 12899,
  lastModifiedDate: dayjs('2024-06-02T21:23'),
  ramainingQuantity: 14596,
};

export const sampleWithPartialData: IStockLevel = {
  id: 16361,
  lastModifiedDate: dayjs('2024-06-03T12:35'),
  ramainingQuantity: 31042,
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IStockLevel = {
  id: 26489,
  lastModifiedDate: dayjs('2024-06-03T17:34'),
  ramainingQuantity: 9103,
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewStockLevel = {
  lastModifiedDate: dayjs('2024-06-03T16:02'),
  ramainingQuantity: 24556,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

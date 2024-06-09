import dayjs from 'dayjs/esm';

import { IStockLevel, NewStockLevel } from './stock-level.model';

export const sampleWithRequiredData: IStockLevel = {
  id: 12899,
  lastModifiedDate: dayjs('2024-06-06T19:51'),
  remainingQuantity: 14596,
};

export const sampleWithPartialData: IStockLevel = {
  id: 16361,
  lastModifiedDate: dayjs('2024-06-07T11:03'),
  remainingQuantity: 31042,
  commonAttributesDetailsJSON: 'bee frightened toughen',
};

export const sampleWithFullData: IStockLevel = {
  id: 2801,
  lastModifiedDate: dayjs('2024-06-06T22:09'),
  remainingQuantity: 25650,
  commonAttributesDetailsJSON: 'fascinate gather',
};

export const sampleWithNewData: NewStockLevel = {
  lastModifiedDate: dayjs('2024-06-07T13:45'),
  remainingQuantity: 27450,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

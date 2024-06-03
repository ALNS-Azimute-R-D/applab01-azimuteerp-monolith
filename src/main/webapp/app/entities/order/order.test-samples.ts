import dayjs from 'dayjs/esm';

import { IOrder, NewOrder } from './order.model';

export const sampleWithRequiredData: IOrder = {
  id: 12675,
  businessCode: 'frankly pristine',
  customerUserId: 'gee',
  placedDate: dayjs('2024-06-03T10:21'),
  status: 'CANCELLED',
};

export const sampleWithPartialData: IOrder = {
  id: 11892,
  businessCode: 'patiently yahoo',
  customerUserId: 'drat gosh redevelop',
  placedDate: dayjs('2024-06-03T17:10'),
  status: 'PENDING',
  invoiceId: 1732,
  estimatedDeliveryDate: dayjs('2024-06-03T03:51'),
};

export const sampleWithFullData: IOrder = {
  id: 19941,
  businessCode: 'furl',
  customerUserId: 'minor',
  placedDate: dayjs('2024-06-03T17:49'),
  totalTaxValue: 19562.09,
  totalDueValue: 21686.16,
  status: 'CANCELLED',
  invoiceId: 29662,
  estimatedDeliveryDate: dayjs('2024-06-03T18:36'),
};

export const sampleWithNewData: NewOrder = {
  businessCode: 'unselfish',
  customerUserId: 'politely',
  placedDate: dayjs('2024-06-03T19:20'),
  status: 'COMPLETED',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

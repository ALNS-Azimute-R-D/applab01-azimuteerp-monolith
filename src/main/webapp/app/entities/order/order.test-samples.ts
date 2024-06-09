import dayjs from 'dayjs/esm';

import { IOrder, NewOrder } from './order.model';

export const sampleWithRequiredData: IOrder = {
  id: 13492,
  businessCode: 'deceivingly vivaciou',
  placedDate: dayjs('2024-06-07T04:07'),
  status: 'COMPLETED',
  activationStatus: 'INVALID',
};

export const sampleWithPartialData: IOrder = {
  id: 14684,
  businessCode: 'honestly',
  placedDate: dayjs('2024-06-07T11:00'),
  totalTaxValue: 15098.4,
  status: 'COMPLETED',
  activationStatus: 'PENDENT',
};

export const sampleWithFullData: IOrder = {
  id: 1813,
  businessCode: 'aw clipper unaccepta',
  placedDate: dayjs('2024-06-07T03:51'),
  totalTaxValue: 7764.56,
  totalDueValue: 17752.39,
  status: 'CANCELLED',
  estimatedDeliveryDate: dayjs('2024-06-07T00:27'),
  activationStatus: 'BLOCKED',
};

export const sampleWithNewData: NewOrder = {
  businessCode: 'phooey strut',
  placedDate: dayjs('2024-06-07T12:16'),
  status: 'COMPLETED',
  activationStatus: 'ON_HOLD',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

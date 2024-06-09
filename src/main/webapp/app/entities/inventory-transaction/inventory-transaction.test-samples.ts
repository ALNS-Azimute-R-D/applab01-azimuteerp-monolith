import dayjs from 'dayjs/esm';

import { IInventoryTransaction, NewInventoryTransaction } from './inventory-transaction.model';

export const sampleWithRequiredData: IInventoryTransaction = {
  id: 24228,
  invoiceId: 31626,
  quantity: 978,
  activationStatus: 'INVALID',
};

export const sampleWithPartialData: IInventoryTransaction = {
  id: 4288,
  invoiceId: 9049,
  transactionCreatedDate: dayjs('2024-06-07T13:31'),
  transactionModifiedDate: dayjs('2024-06-07T14:18'),
  quantity: 9209,
  transactionComments: 'metallic',
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: IInventoryTransaction = {
  id: 6382,
  invoiceId: 12022,
  transactionCreatedDate: dayjs('2024-06-07T06:13'),
  transactionModifiedDate: dayjs('2024-06-07T00:51'),
  quantity: 3741,
  transactionComments: 'noteworthy beloved',
  activationStatus: 'PENDENT',
};

export const sampleWithNewData: NewInventoryTransaction = {
  invoiceId: 3903,
  quantity: 31770,
  activationStatus: 'PENDENT',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

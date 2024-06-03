import dayjs from 'dayjs/esm';

import { IInventoryTransaction, NewInventoryTransaction } from './inventory-transaction.model';

export const sampleWithRequiredData: IInventoryTransaction = {
  id: 7970,
  invoiceId: 24228,
  quantity: 31626,
};

export const sampleWithPartialData: IInventoryTransaction = {
  id: 993,
  invoiceId: 2094,
  transactionCreatedDate: dayjs('2024-06-03T18:02'),
  quantity: 9049,
  comments: 'till',
};

export const sampleWithFullData: IInventoryTransaction = {
  id: 25179,
  invoiceId: 19209,
  transactionCreatedDate: dayjs('2024-06-03T08:27'),
  transactionModifiedDate: dayjs('2024-06-03T04:11'),
  quantity: 6382,
  comments: 'distort fair',
};

export const sampleWithNewData: NewInventoryTransaction = {
  invoiceId: 11577,
  quantity: 12103,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

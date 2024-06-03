import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 11907,
  businessCode: 'chaperone until',
  description: 'of',
  numberOfInstallmentsOriginal: 958,
  status: 'PAYING_IN_INSTALLMENTS',
};

export const sampleWithPartialData: IInvoice = {
  id: 22176,
  businessCode: 'ew use',
  originalOrderId: 5539,
  dueDate: dayjs('2024-06-03T12:18'),
  description: 'since',
  amountDueValue: 10339.8,
  numberOfInstallmentsOriginal: 831,
  status: 'CANCELLED',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IInvoice = {
  id: 8818,
  businessCode: 'notwithstanding',
  originalOrderId: 16562,
  invoiceDate: dayjs('2024-06-03T12:53'),
  dueDate: dayjs('2024-06-02T23:28'),
  description: 'rampage aboard shiny',
  taxValue: 21561.52,
  shippingValue: 388.09,
  amountDueValue: 520.85,
  numberOfInstallmentsOriginal: 24074,
  numberOfInstallmentsPaid: 13576,
  amountPaidValue: 19898.73,
  status: 'ISSUED',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewInvoice = {
  businessCode: 'discovery worth',
  description: 'ick',
  numberOfInstallmentsOriginal: 2462,
  status: 'PAID_ONCE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

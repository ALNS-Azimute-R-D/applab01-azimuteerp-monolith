import dayjs from 'dayjs/esm';

import { IInvoice, NewInvoice } from './invoice.model';

export const sampleWithRequiredData: IInvoice = {
  id: 11907,
  businessCode: 'chaperone until',
  description: 'of',
  numberOfInstallmentsOriginal: 958,
  status: 'PAYING_IN_INSTALLMENTS',
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IInvoice = {
  id: 22176,
  businessCode: 'ew use',
  dueDate: dayjs('2024-06-07T15:26'),
  description: 'yearly including',
  amountDueValue: 16838.94,
  numberOfInstallmentsOriginal: 8834,
  status: 'PAID_ONCE',
  customAttributesDetailsJSON: 'single characterize on',
  activationStatus: 'ON_HOLD',
};

export const sampleWithFullData: IInvoice = {
  id: 12415,
  businessCode: 'shrilly careful',
  invoiceDate: dayjs('2024-06-07T08:35'),
  dueDate: dayjs('2024-06-07T07:28'),
  description: 'once regulation clueless',
  taxValue: 21387.13,
  shippingValue: 31045.19,
  amountDueValue: 2462.53,
  numberOfInstallmentsOriginal: 1832,
  numberOfInstallmentsPaid: 18569,
  amountPaidValue: 16145.36,
  status: 'PAID_ONCE',
  customAttributesDetailsJSON: 'flick diagnosis',
  activationStatus: 'ON_HOLD',
};

export const sampleWithNewData: NewInvoice = {
  businessCode: 'eggnog',
  description: 'manufacture an a',
  numberOfInstallmentsOriginal: 20512,
  status: 'ISSUED',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

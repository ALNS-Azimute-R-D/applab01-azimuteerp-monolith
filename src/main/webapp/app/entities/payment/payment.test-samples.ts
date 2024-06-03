import dayjs from 'dayjs/esm';

import { IPayment, NewPayment } from './payment.model';

export const sampleWithRequiredData: IPayment = {
  id: 10845,
  installmentNumber: 17017,
  paymentDueDate: dayjs('2024-06-03T08:36'),
  paymentPaidDate: dayjs('2024-06-03T01:08'),
  paymentAmount: 16060.54,
  typeOfPayment: 'BANK_TRANSFER',
  status: 'PAID',
};

export const sampleWithPartialData: IPayment = {
  id: 18677,
  installmentNumber: 2864,
  paymentDueDate: dayjs('2024-06-03T05:29'),
  paymentPaidDate: dayjs('2024-06-03T07:02'),
  paymentAmount: 20522.46,
  typeOfPayment: 'DEBIT',
  status: 'DELAYED',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IPayment = {
  id: 4825,
  installmentNumber: 22524,
  paymentDueDate: dayjs('2024-06-02T23:52'),
  paymentPaidDate: dayjs('2024-06-02T23:58'),
  paymentAmount: 22913.11,
  typeOfPayment: 'OTHER',
  status: 'OPEN',
  extraDetails: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewPayment = {
  installmentNumber: 16531,
  paymentDueDate: dayjs('2024-06-03T16:44'),
  paymentPaidDate: dayjs('2024-06-03T13:29'),
  paymentAmount: 3770.03,
  typeOfPayment: 'CREDIT',
  status: 'OPEN',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

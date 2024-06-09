import dayjs from 'dayjs/esm';

import { IPayment, NewPayment } from './payment.model';

export const sampleWithRequiredData: IPayment = {
  id: 17017,
  installmentNumber: 17084,
  paymentDueDate: dayjs('2024-06-06T23:33'),
  paymentPaidDate: dayjs('2024-06-07T07:46'),
  paymentAmount: 22421.43,
  typeOfPayment: 'DEBIT',
  statusPayment: 'OPEN',
  activationStatus: 'PENDENT',
};

export const sampleWithPartialData: IPayment = {
  id: 21331,
  installmentNumber: 19224,
  paymentDueDate: dayjs('2024-06-07T04:30'),
  paymentPaidDate: dayjs('2024-06-07T06:58'),
  paymentAmount: 15554.4,
  typeOfPayment: 'CASH',
  statusPayment: 'PAID',
  customAttributesDetailsJSON: 'inasmuch who instructive',
  activationStatus: 'ON_HOLD',
};

export const sampleWithFullData: IPayment = {
  id: 25928,
  installmentNumber: 586,
  paymentDueDate: dayjs('2024-06-07T19:00'),
  paymentPaidDate: dayjs('2024-06-07T10:01'),
  paymentAmount: 31362.29,
  typeOfPayment: 'CASH',
  statusPayment: 'OPEN',
  customAttributesDetailsJSON: 'next across',
  activationStatus: 'ON_HOLD',
};

export const sampleWithNewData: NewPayment = {
  installmentNumber: 28572,
  paymentDueDate: dayjs('2024-06-07T02:21'),
  paymentPaidDate: dayjs('2024-06-07T10:15'),
  paymentAmount: 11967.93,
  typeOfPayment: 'DEBIT',
  statusPayment: 'CANCELLED',
  activationStatus: 'ACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

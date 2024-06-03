import { IPaymentMethod, NewPaymentMethod } from './payment-method.model';

export const sampleWithRequiredData: IPaymentMethod = {
  id: 31183,
  code: 'through ce',
  description: 'duh',
};

export const sampleWithPartialData: IPaymentMethod = {
  id: 25056,
  code: 'cabinet',
  description: 'scratchy',
};

export const sampleWithFullData: IPaymentMethod = {
  id: 23950,
  code: 'psst plus ',
  description: 'raise following along',
  businessHandlerClazz: 'paddle',
};

export const sampleWithNewData: NewPaymentMethod = {
  code: 'unbearably',
  description: 'recklessly yahoo quarterly',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

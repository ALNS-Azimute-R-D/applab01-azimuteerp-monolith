import { IOrderItem, NewOrderItem } from './order-item.model';

export const sampleWithRequiredData: IOrderItem = {
  id: 20990,
  quantity: 1223,
  totalPrice: 23623.28,
  status: 'OUT_OF_STOCK',
};

export const sampleWithPartialData: IOrderItem = {
  id: 999,
  quantity: 30825,
  totalPrice: 11635.62,
  status: 'OUT_OF_STOCK',
};

export const sampleWithFullData: IOrderItem = {
  id: 27287,
  quantity: 17006,
  totalPrice: 15091.82,
  status: 'AVAILABLE',
};

export const sampleWithNewData: NewOrderItem = {
  quantity: 5852,
  totalPrice: 21570.9,
  status: 'AVAILABLE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

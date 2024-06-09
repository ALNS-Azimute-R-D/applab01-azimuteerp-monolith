import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 5658,
  listPrice: 5147.27,
  discontinued: false,
  activationStatus: 'BLOCKED',
};

export const sampleWithPartialData: IProduct = {
  id: 20915,
  description: 'access',
  standardCost: 22006.33,
  listPrice: 21854.62,
  reorderLevel: 28741,
  quantityPerUnit: 'consequently unkempt',
  discontinued: true,
  suggestedCategory: 'howl',
  attachments: '../fake-data/blob/hipster.png',
  attachmentsContentType: 'unknown',
  activationStatus: 'ON_HOLD',
};

export const sampleWithFullData: IProduct = {
  id: 21481,
  productSKU: 'wiseguy pilaf onto',
  productName: 'itchy burglarize',
  description: 'lining meaningfully cornerstone',
  standardCost: 30119.19,
  listPrice: 2137.43,
  reorderLevel: 867,
  targetLevel: 28415,
  quantityPerUnit: 'sour what',
  discontinued: false,
  minimumReorderQuantity: 2837,
  suggestedCategory: 'duh',
  attachments: '../fake-data/blob/hipster.png',
  attachmentsContentType: 'unknown',
  activationStatus: 'ON_HOLD',
};

export const sampleWithNewData: NewProduct = {
  listPrice: 25778.31,
  discontinued: false,
  activationStatus: 'INACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

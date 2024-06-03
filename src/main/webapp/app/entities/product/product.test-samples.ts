import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 5658,
  listPrice: 5147.27,
  discontinued: false,
};

export const sampleWithPartialData: IProduct = {
  id: 20915,
  standardCost: 3371.95,
  listPrice: 21705.6,
  reorderLevel: 4622,
  targetLevel: 14181,
  discontinued: true,
  minimumReorderQuantity: 18305,
  attachments: '../fake-data/blob/hipster.png',
  attachmentsContentType: 'unknown',
  supplierIds: '../fake-data/blob/hipster.txt',
};

export const sampleWithFullData: IProduct = {
  id: 15030,
  productSKU: 'hm',
  productName: 'violet out',
  description: '../fake-data/blob/hipster.txt',
  standardCost: 9733.13,
  listPrice: 13247.61,
  reorderLevel: 1335,
  targetLevel: 10082,
  quantityPerUnit: 'till retail',
  discontinued: false,
  minimumReorderQuantity: 30462,
  suggestedCategory: 'onto wretched',
  attachments: '../fake-data/blob/hipster.png',
  attachmentsContentType: 'unknown',
  supplierIds: '../fake-data/blob/hipster.txt',
};

export const sampleWithNewData: NewProduct = {
  listPrice: 14723.47,
  discontinued: true,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

import { IPaymentGateway, NewPaymentGateway } from './payment-gateway.model';

export const sampleWithRequiredData: IPaymentGateway = {
  id: 18447,
  aliasCode: 'when',
  description: 'but',
  activationStatus: 'INACTIVE',
};

export const sampleWithPartialData: IPaymentGateway = {
  id: 14174,
  aliasCode: 'fiercely ferociously',
  description: 'meanwhile',
  businessHandlerClazz: 'considering atop inasmuch',
  activationStatus: 'PENDENT',
};

export const sampleWithFullData: IPaymentGateway = {
  id: 20928,
  aliasCode: 'defiantly afterwards',
  description: 'newsstand outside since',
  businessHandlerClazz: 'size quaint nifty',
  activationStatus: 'INACTIVE',
};

export const sampleWithNewData: NewPaymentGateway = {
  aliasCode: 'wherever',
  description: 'er qua',
  activationStatus: 'ON_HOLD',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

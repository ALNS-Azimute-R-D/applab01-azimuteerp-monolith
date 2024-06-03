import { IOrganizationRole, NewOrganizationRole } from './organization-role.model';

export const sampleWithRequiredData: IOrganizationRole = {
  id: 4363,
  roleName: 'before lest',
  activationStatus: 'ACTIVE',
};

export const sampleWithPartialData: IOrganizationRole = {
  id: 2055,
  roleName: 'wetly miserably',
  activationStatus: 'ON_HOLD',
};

export const sampleWithFullData: IOrganizationRole = {
  id: 16133,
  roleName: 'second amidst',
  activationStatus: 'INACTIVE',
};

export const sampleWithNewData: NewOrganizationRole = {
  roleName: 'schuss',
  activationStatus: 'ON_HOLD',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

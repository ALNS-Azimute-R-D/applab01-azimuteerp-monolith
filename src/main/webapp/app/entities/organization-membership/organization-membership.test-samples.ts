import dayjs from 'dayjs/esm';

import { IOrganizationMembership, NewOrganizationMembership } from './organization-membership.model';

export const sampleWithRequiredData: IOrganizationMembership = {
  id: 30161,
  joinedAt: dayjs('2024-06-03'),
  activationStatus: 'BLOCKED',
};

export const sampleWithPartialData: IOrganizationMembership = {
  id: 23807,
  joinedAt: dayjs('2024-06-03'),
  activationStatus: 'BLOCKED',
};

export const sampleWithFullData: IOrganizationMembership = {
  id: 22853,
  joinedAt: dayjs('2024-06-03'),
  activationStatus: 'INACTIVE',
};

export const sampleWithNewData: NewOrganizationMembership = {
  joinedAt: dayjs('2024-06-03'),
  activationStatus: 'INACTIVE',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

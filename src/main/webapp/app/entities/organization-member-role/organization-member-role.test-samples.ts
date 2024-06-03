import dayjs from 'dayjs/esm';

import { IOrganizationMemberRole, NewOrganizationMemberRole } from './organization-member-role.model';

export const sampleWithRequiredData: IOrganizationMemberRole = {
  id: 30910,
  joinedAt: dayjs('2024-06-03'),
};

export const sampleWithPartialData: IOrganizationMemberRole = {
  id: 15764,
  joinedAt: dayjs('2024-06-02'),
};

export const sampleWithFullData: IOrganizationMemberRole = {
  id: 26914,
  joinedAt: dayjs('2024-06-03'),
};

export const sampleWithNewData: NewOrganizationMemberRole = {
  joinedAt: dayjs('2024-06-03'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

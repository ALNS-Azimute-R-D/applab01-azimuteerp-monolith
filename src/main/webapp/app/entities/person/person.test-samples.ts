import dayjs from 'dayjs/esm';

import { IPerson, NewPerson } from './person.model';

export const sampleWithRequiredData: IPerson = {
  id: 8305,
  firstName: 'Irwin',
  lastName: 'Kassulke',
  birthDate: dayjs('2024-06-02'),
  gender: 'OTHER',
  streetAddress: 'lest so',
  postalCode: 'vigilant ',
  mainEmail: '5@Jgt8.+tAnV',
  activationStatus: 'INVALID',
};

export const sampleWithPartialData: IPerson = {
  id: 2078,
  firstName: 'Annette',
  lastName: 'Hartmann',
  birthDate: dayjs('2024-06-03'),
  gender: 'OTHER',
  codeBI: 'wherever',
  codeNIF: 'barring kissingly',
  streetAddress: 'worth severe as',
  houseNumber: 'vivaciously',
  postalCode: 'snakebite',
  mainEmail: 'HLj@fVpL>.kK',
  mobilePhoneNumber: 'blueberry',
  occupation: 'streetcar quizzically',
  usernameInOAuth2: 'await',
  userIdInOAuth2: 'or',
  extraDetails: '../fake-data/blob/hipster.txt',
  activationStatus: 'PENDENT',
  avatarImg: '../fake-data/blob/hipster.png',
  avatarImgContentType: 'unknown',
};

export const sampleWithFullData: IPerson = {
  id: 11697,
  firstName: 'Aliya',
  lastName: 'Dooley',
  birthDate: dayjs('2024-06-02'),
  gender: 'OTHER',
  codeBI: 'advise',
  codeNIF: 'circa obnoxiously ko',
  streetAddress: 'frantically peruse',
  houseNumber: 'massive',
  locationName: 'sans by',
  postalCode: 'unaccount',
  mainEmail: "S|P<2@}'.Mf?",
  landPhoneNumber: 'accidentally so',
  mobilePhoneNumber: 'fast positively',
  occupation: 'who',
  preferredLanguage: 'bean ',
  usernameInOAuth2: 'yowza',
  userIdInOAuth2: 'indeed lest incident',
  extraDetails: '../fake-data/blob/hipster.txt',
  activationStatus: 'PENDENT',
  avatarImg: '../fake-data/blob/hipster.png',
  avatarImgContentType: 'unknown',
};

export const sampleWithNewData: NewPerson = {
  firstName: 'Javonte',
  lastName: 'Wintheiser-Rice',
  birthDate: dayjs('2024-06-02'),
  gender: 'MALE',
  streetAddress: 'since about',
  postalCode: 'alongside',
  mainEmail: ')EcR@j2udN.Yr',
  activationStatus: 'INVALID',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

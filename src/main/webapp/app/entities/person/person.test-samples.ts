import dayjs from 'dayjs/esm';

import { IPerson, NewPerson } from './person.model';

export const sampleWithRequiredData: IPerson = {
  id: 14571,
  firstname: 'overshoot',
  lastname: 'alarming defrag evergreen',
  birthDate: dayjs('2024-06-07'),
  gender: 'OTHER',
  streetAddress: 'underneath midst',
  postalCode: 'density b',
  mainEmail: "L6foV@PL'SX9.O^4?H",
  activationStatus: 'ON_HOLD',
};

export const sampleWithPartialData: IPerson = {
  id: 24202,
  firstname: 'as helpfully selfishly',
  lastname: 'daintily selfish',
  birthDate: dayjs('2024-06-07'),
  gender: 'OTHER',
  codeNIF: 'wetland trophy',
  streetAddress: 'plain when douse',
  postalCode: 'pale yuck',
  mainEmail: '[Y(Bg@C$.d',
  landPhoneNumber: 'almost',
  mobilePhoneNumber: 'ornate',
  usernameInOAuth2: 'before under hmph',
  customAttributesDetailsJSON: 'start trafficker wiry',
  activationStatus: 'PENDENT',
};

export const sampleWithFullData: IPerson = {
  id: 9551,
  firstname: 'faculty',
  lastname: 'accidentally soon by',
  fullname: 'fast positively',
  birthDate: dayjs('2024-06-07'),
  gender: 'FEMALE',
  codeBI: 'creativity stammer f',
  codeNIF: 'punctuation',
  streetAddress: 'afterwards',
  houseNumber: 'our',
  locationName: 'why however',
  postalCode: 'yahoo',
  mainEmail: '[*$II@r\\(R.2',
  landPhoneNumber: 'boo usefully el',
  mobilePhoneNumber: 'gosh compost pi',
  occupation: 'creative inch jealous',
  preferredLanguage: 'phooe',
  usernameInOAuth2: 'though phooey',
  userIdInOAuth2: 'earthworm lazy how',
  customAttributesDetailsJSON: 'ringworm stag whereas',
  activationStatus: 'INVALID',
  avatarImg: '../fake-data/blob/hipster.png',
  avatarImgContentType: 'unknown',
};

export const sampleWithNewData: NewPerson = {
  firstname: 'near',
  lastname: 'overrate sequester',
  birthDate: dayjs('2024-06-07'),
  gender: 'OTHER',
  streetAddress: 'rust notwithstanding',
  postalCode: 'jaywalk m',
  mainEmail: 'Sub7@G.H',
  activationStatus: 'BLOCKED',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

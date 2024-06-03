import { ICategory, NewCategory } from './category.model';

export const sampleWithRequiredData: ICategory = {
  id: 19097,
  name: 'doubt mmm',
};

export const sampleWithPartialData: ICategory = {
  id: 4218,
  name: 'united what',
  description: 'willfully',
};

export const sampleWithFullData: ICategory = {
  id: 13807,
  acronym: 'scratchy',
  name: 'yippee',
  description: 'deplore',
  handlerClazzName: 'amidst outrage although',
};

export const sampleWithNewData: NewCategory = {
  name: 'weepy',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

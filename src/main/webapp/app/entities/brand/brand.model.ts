export interface IBrand {
  id: number;
  acronym?: string | null;
  name?: string | null;
  description?: string | null;
  logoBrand?: string | null;
  logoBrandContentType?: string | null;
}

export type NewBrand = Omit<IBrand, 'id'> & { id: null };

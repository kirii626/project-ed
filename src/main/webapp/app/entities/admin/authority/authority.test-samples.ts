import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '206ab035-fb38-4109-9842-67236f8cebe6',
};

export const sampleWithPartialData: IAuthority = {
  name: '10b65073-b798-4dbd-8ac5-88b1683b2826',
};

export const sampleWithFullData: IAuthority = {
  name: '5e66ffb2-ab1f-44c8-90fa-371f7a0d9435',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

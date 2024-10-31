import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 4310,
  login: '+IR@kctqoy',
};

export const sampleWithPartialData: IUser = {
  id: 21369,
  login: 'rL@8rr\\orqbr6D\\Flo5\\>ggwk7G\\bh8BxZ\\pAzWZQ',
};

export const sampleWithFullData: IUser = {
  id: 27150,
  login: 'h',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

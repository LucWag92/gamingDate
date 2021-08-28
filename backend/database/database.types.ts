import { Pool } from 'pg';
import IAccountdata from '../Model/AccountData';
import { ISignupParams } from '../Routes/signup_route.types';

export default interface IDatabase {
  pgPool: Pool;
  isEmailNotInDB: (email: string) => Promise<boolean>;
  createAccount: (newUser: ISignupParams) => Promise<boolean>;
  findAccountByEMail: (email: string) => Promise<IAccountdata[]>;
}

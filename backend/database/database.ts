import hashPassword from './hashPassword';
import validator from 'email-validator';
import { ISignupParams } from '../Routes/signup_route';

import { pgPool } from './databaseConfig';
import IAccountdata from '../Model/AccountData';

import { Pool } from 'pg';

export interface IDatabase {
  pgPool: Pool;
  isEmailNotInDB: (email: string) => Promise<boolean>;
  createAccount: (newUser: ISignupParams) => Promise<boolean>;
  findAccountByEMail: (email: string) => Promise<IAccountdata[]>;
  findAccountByID: (accountDataId: number) => Promise<IAccountdata[]>;
}

export default class Database implements IDatabase {
  pgPool: Pool = pgPool;

  async findAccountByID(accountDataId: number) {
    const queryText = `SELECT * FROM public.accountdata WHERE accountdataid = '${accountDataId}'`;
    const client = await pgPool.connect();
    return client
      .query<IAccountdata>(queryText)
      .then((res) => {
        return res.rows;
      })
      .catch((err) => {
        console.log(err);
        return [] as IAccountdata[];
      })
      .finally(() => client.release());
  }
  async findAccountByEMail(email: string) {
    const queryText = `SELECT * FROM public.accountdata WHERE email = '${email}'`;
    const client = await pgPool.connect();
    return client
      .query<IAccountdata>(queryText)
      .then((res) => {
        return res.rows;
      })
      .catch((err) => {
        console.log(err);
        return [] as IAccountdata[];
      })
      .finally(() => client.release());
  }

  async isEmailNotInDB(email: string) {
    const queryText = `SELECT email FROM public.accountdata WHERE email = '${email}'`;
    const client = await this.pgPool.connect();
    return client
      .query<IAccountdata>(queryText)
      .then((res) => {
        if (res.rowCount === 0) {
          return true;
        } else {
          return false;
        }
      })
      .catch((err) => {
        console.log(err);
        return false;
      })
      .finally(() => client.release());
  }
  async createAccount(newUser: ISignupParams) {
    const hashedpassword = await hashPassword(newUser.password);
    const queryText = `INSERT INTO public.accountdata (email, hashedpassword) 
      VALUES ('${newUser.email}', '${hashedpassword}');`;

    const client = await pgPool.connect();
    return client
      .query(queryText)
      .then((res) => {
        console.log(res);
        return true;
      })
      .catch((err) => {
        console.log(err);
        return false;
      })
      .finally(() => client.release());
  }
}

export const isEmailInValidFormat = (email: string) => {
  return validator.validate(email);
};

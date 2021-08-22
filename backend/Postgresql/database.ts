import pg from "pg";
import hashPassword from "./hashPassword";
import validator from "email-validator";
import { ISignupParams } from "../Routes/signup_route.types";
import IDatabase from "./database";

export default class Database implements IDatabase {
    isEmailNotInDB(email: string) {
        const client = new pg.Client({
            user: process.env.DB_USER,
            host: "localhost",
            database: process.env.DB_NAME,
            password: process.env.DB_PW,
            port: 5432,
        });
        client.connect();
        return client
            .query(
                `SELECT email FROM public.accountdata WHERE email = '${email}'`
            )
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
            .finally(() => client.end());
    }
    async createUser(newUser: ISignupParams) {
        const hashedpassword = await hashPassword(newUser.password);
        const client = new pg.Client({
            user: process.env.DB_USER,
            host: "localhost",
            database: process.env.DB_NAME,
            password: process.env.DB_PW,
            port: 5432,
        });
        client.connect();
        return client
            .query(
                `INSERT INTO public.accountdata (email, hashedpassword) 
                VALUES ('${newUser.email}', '${hashedpassword}');`
            )
            .then((res) => {
                console.log(res);
                return true;
            })
            .catch((err) => {
                console.log(err);
                return false;
            })
            .finally(() => client.end());
    }
}

export const isEmailInValidFormat = (email: string) => {
    return validator.validate(email);
};

import { ISignupParams } from "../Routes/signup_route.types";

export default interface IDatabase {
    isEmailNotInDB: (email: string) => Promise<boolean>;
    createUser: (newUser: ISignupParams) => Promise<boolean>;
}

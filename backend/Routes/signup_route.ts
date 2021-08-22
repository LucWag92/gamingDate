import { Router } from "express";
import { isEmailInValidFormat } from "../Postgresql/database";
import IDatabase from "../Postgresql/database";
import { ISignupParams } from "./signup_route.types";

export default (database: IDatabase) => {
    const signUpRouter = Router();

    signUpRouter.post("/signup", async (req, res) => {
        const signupInfo: ISignupParams = req.body; //Get the parsed information
        // check params
        if (!!!signupInfo.email || !!!signupInfo.password) {
            res.status(400);
            res.send("email and password must be provided");
            return;
        }
        // check if email is valid format
        if (!isEmailInValidFormat(signupInfo.email)) {
            res.status(400);
            res.send("email not in right format");
        }
        // check if email is already in db
        const isEmailNotInDB = await database.isEmailNotInDB(signupInfo.email);
        if (!isEmailNotInDB) {
            if (isEmailNotInDB === null) {
                res.status(500);
                res.send("Internal Server Error: Checking Email");
            } else {
                res.status(409);
                res.send("email already in use");
            }
            return;
        }
        // Create new User
        database
            .createUser(signupInfo)
            .then((creationStatus) => {
                if (creationStatus) {
                    res.status(200);
                    res.send("Signup Successfull");
                } else {
                    res.status(500);
                    res.send("Internal Server Error: Saving new User");
                }
            })
            .catch((err) => {
                console.log(err);
                res.status(500);
                res.send("Internal Server Error");
            });
    });
    return signUpRouter;
};

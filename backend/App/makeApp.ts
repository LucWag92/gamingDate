import express from "express";
import cookieParser from "cookie-parser";
import session from "express-session";
import signUpRouter from "../Routes/signup_route";
import logInRouter from "../Routes/login_route";
import IDatabase from "../Postgresql/database.types";

export default (database: IDatabase) => {
    const app = express();

    app.use(express.urlencoded({ extended: false }));
    app.use(express.json());

    app.use(cookieParser());
    app.use(session({ secret: "Its a secret" }));

    app.use("/api/v1", signUpRouter(database));
    app.use("/api/v1", logInRouter);
    return app;
};

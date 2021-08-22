import { Router } from "express";
import { LoginParams } from "./login_route.types";
const logInRouter = Router();

logInRouter.post("/login", (req, res) => {
    const loginInfo: LoginParams = req.body; //Get the parsed information
    if (!!!loginInfo.email || !!!loginInfo.password) {
        res.status(400);
        res.send("email and password must be provided");
    }
    res.send("LogIn");
});

export default logInRouter;

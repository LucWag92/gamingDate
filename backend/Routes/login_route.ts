import { Router } from 'express';
import IDatabase from '../database/database.types';
import bcrypt from 'bcrypt';
import { LoginParams } from './login_route.types';
import passport from 'passport';

export default (database: IDatabase) => {
  const logInRouter = Router();

  logInRouter.post(
    '/login',
    passport.authenticate('local'),
    async (req, res) => {
      console.log(req.isAuthenticated()); // fn to check if authenticated
      console.log(req.user); // was added by passport.authenticate() when credentials were right
      console.log(req.session);
      const loginInfo: LoginParams = req.body; //Get the parsed information
      if (!!!loginInfo.email || !!!loginInfo.password) {
        res.status(400);
        res.json({ msg: 'email and password must be provided' });
      }
      const accountData = await database.findAccountByEMail(loginInfo.email);
      const isPasswordSame = await bcrypt.compare(
        loginInfo.password,
        accountData[0].hashedpassword
      );
      if (!isPasswordSame) {
        res.status(400);
        res.json({ msg: 'Wrong Password' });
        return;
      }
      res.json(accountData);
    }
  );

  return logInRouter;
};

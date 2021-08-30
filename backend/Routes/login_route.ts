import { Router } from 'express';
import IDatabase from '../database/database';
import bcrypt from 'bcrypt';
import issueJWT from '../Auth/issueJWT';

export type LoginParams = {
  email: string;
  password: string;
};

export default (database: IDatabase) => {
  const logInRouter = Router();

  logInRouter.post('/login', async (req, res) => {
    console.log('--- Route: /login');
    const loginInfo: LoginParams = req.body; //Get the parsed information
    if (!!!loginInfo.email || !!!loginInfo.password) {
      res.status(400);
      res.json({ msg: 'email and password must be provided' });
    }
    const accountDatas = await database.findAccountByEMail(loginInfo.email);
    const isPasswordValid = await bcrypt.compare(
      loginInfo.password,
      accountDatas[0].hashedpassword
    );
    if (!isPasswordValid) {
      res.status(400);
      res.json({ msg: 'Wrong Password' });
      return;
    }
    const tokenObject = issueJWT(accountDatas[0]);
    res.status(200).json({
      success: true,
      token: tokenObject.token,
      expiresIn: tokenObject.expires,
    });
  });

  return logInRouter;
};

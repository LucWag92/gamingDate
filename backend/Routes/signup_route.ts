import { Router } from 'express';
import { isEmailInValidFormat } from '../database/database';
import IDatabase from '../database/database';

export type ISignupParams = {
  email: string;
  password: string;
};

export default (database: IDatabase) => {
  const signUpRouter = Router();

  signUpRouter.post('/signup', async (req, res) => {
    const signupInfo: ISignupParams = req.body; //Get the parsed information
    // check params
    if (!!!signupInfo.email || !!!signupInfo.password) {
      res.status(400);
      res.json({ msg: 'email and password must be provided' });
      return;
    }
    // check if email is valid format
    if (!isEmailInValidFormat(signupInfo.email)) {
      res.status(400);
      res.json({ msg: 'email not in right format' });
      return;
    }
    // check if email is already in db
    const isEmailNotInDB = await database.isEmailNotInDB(signupInfo.email);
    if (!isEmailNotInDB) {
      if (isEmailNotInDB === null) {
        res.status(500);
        res.json({ msg: 'Internal Server Error: Checking Email' });
      } else {
        res.status(409);
        res.json({ msg: 'email already in use' });
      }
      return;
    }
    // Create new User
    database
      .createAccount(signupInfo)
      .then((creationStatus) => {
        if (creationStatus) {
          res.status(200);
          res.json({ msg: 'Signup Successfull' });
        } else {
          res.status(500);
          res.json({ msg: 'Internal Server Error: Saving new User' });
        }
      })
      .catch((err) => {
        console.log(err);
        res.status(500);
        res.send('Internal Server Error');
      });
  });
  return signUpRouter;
};

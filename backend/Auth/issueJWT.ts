import jsonwebtoken from 'jsonwebtoken';
import IAccountdata from '../Model/AccountData';

/**
 * @param {*} user - The user object.  We need this to set the JWT `sub` payload property to the MongoDB user ID
 */
export default function issueJWT(accountData: IAccountdata) {
  try {
    const expiresIn = '1m'; //'1d';

    const payload = {
      accountdataid: accountData.accountdataid,
      //iat: Date.now(), // this messes with the default setup. Dont Use
    };

    const signedToken = jsonwebtoken.sign(
      payload,
      process.env.JWTKEY as string,
      {
        expiresIn: expiresIn,
      }
    );

    return {
      token: 'Bearer ' + signedToken,
      expires: expiresIn,
    };
  } catch (error) {
    throw new Error(error);
  }
}

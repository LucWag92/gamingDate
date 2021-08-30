import { PassportStatic } from 'passport';
import { Strategy as JwtStrategy } from 'passport-jwt';
import { ExtractJwt } from 'passport-jwt';
import IDatabase from '../database/database';

// At a minimum, you must pass the `jwtFromRequest` and `secretOrKey` properties
type JwtPayload = {
  accountdataid: string;
  exp: number;
  iat: number;
};
// app.js will pass the global passport object here, and this function will configure it
export default (passport: PassportStatic, database: IDatabase) => {
  console.log('Wrapper Passport -- Start');

  const jwtStrategy = new JwtStrategy(
    {
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
      secretOrKey: process.env.JWTKEY,
    },
    async (jwt_payload: JwtPayload, done) => {
      console.log('Wrapper Passport -- VerifyCallback');
      console.log(jwt_payload);
      // Since we are here, the JWT is valid!

      // We will assign the `sub` property on the JWT to the database ID of user
      return await database
        .findAccountByID(parseInt(jwt_payload.accountdataid))
        .then((accountDatas) => {
          console.log(jwt_payload.accountdataid);
          if (accountDatas) {
            // Since we are here, the JWT is valid and our user is valid, so we are authorized!
            return done(null, accountDatas[0]);
          } else {
            return done(null, false);
          }
        });
    }
  );

  // The JWT payload is passed into the verify callback
  passport.use(jwtStrategy);
};

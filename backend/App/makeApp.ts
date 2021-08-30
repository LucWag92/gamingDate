import express from 'express';
import session from 'express-session';
import helmet from 'helmet';
import bcrypt from 'bcrypt';
// ===== JWT with passport
import passport from 'passport';
import passportLocal from 'passport-local';
const LocalStrategy = passportLocal.Strategy;

// ===== Routes
import signUpRouter from '../Routes/signup_route';
import logInRouter from '../Routes/login_route';
// ===== Utils
import IDatabase from '../database/database.types';
import IAccountdata from '../Model/AccountData';

export default (database: IDatabase) => {
  // ===== JWT Config
  // const opts: passportJWT.StrategyOptions = {
  //   jwtFromRequest: passportJWT.ExtractJwt.fromAuthHeaderAsBearerToken(),
  //   secretOrKey: process.env.JWT_SECRET,
  //   issuer: process.env.JWT_ISSUER,
  //   audience: process.env.JWT_AUDIENCE,
  // };

  const app = express();
  // ===== Middleware
  app.use(helmet());
  app.use(express.urlencoded({ extended: false }));
  app.use(express.json());
  // important for passport to work because it uses the created session property on req
  // express-session creates the property session on req. Must run before passport is used
  app.use(
    session({
      secret: 'keyboard cat', // rename secret
      resave: false,
      saveUninitialized: true,
      cookie: { secure: true },
    })
  );

  // ===== Auth Middleware
  // Tutorial on https://levelup.gitconnected.com/everything-you-need-to-know-about-the-passport-local-passport-js-strategy-633bbab6195
  // Middleware/Function which is used when passport.authenticate is run in Route
  passport.use(
    new LocalStrategy(
      { usernameField: 'email', passwordField: 'password' },
      (email, password, cb) => {
        console.log('Passport Use');
        database
          .findAccountByEMail(email)
          .then(async (accountDatas) => {
            const accountData = accountDatas[0];
            if (!accountData) {
              // If no accountData is found then call cb which returns values back to authenticate function. 1 arg: error 2. arg: return for User
              return cb(null, false);
            }
            if (!(await bcrypt.compare(password, accountData.hashedpassword))) {
              return cb(null, false);
            }
            return cb(null, accountData);
          })
          .catch((err) => cb(err));
      }
    )
  );

  // Function which serialize and deserialze users/accountData from the current session object
  passport.serializeUser((accountData, cb) => {
    console.log('serialize User');
    cb(null, accountData);
  });
  passport.deserializeUser<IAccountdata>((accountData, cb) => {
    console.log('deserialize User');
    cb(null, accountData);
  });
  app.use(passport.initialize());
  app.use(passport.session());

  app.use('/api/v1', signUpRouter(database));
  app.use('/api/v1', logInRouter(database));
  return app;
};

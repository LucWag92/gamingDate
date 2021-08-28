import express from 'express';
import session from 'express-session';
import helmet from 'helmet';
// ===== JWT with passport
import passport from 'passport';
import passportJWT from 'passport-jwt';

// ===== Routes
import signUpRouter from '../Routes/signup_route';
import logInRouter from '../Routes/login_route';
// ===== Utils
import IDatabase from '../database/database.types';

export default (database: IDatabase) => {
  // ===== JWT Config
  const opts: passportJWT.StrategyOptions = {
    jwtFromRequest: passportJWT.ExtractJwt.fromAuthHeaderAsBearerToken(),
    secretOrKey: process.env.JWT_SECRET,
    issuer: process.env.JWT_ISSUER,
    audience: process.env.JWT_AUDIENCE,
  };

  const app = express();

  // ===== Middleware
  app.use(helmet());
  app.use(express.urlencoded({ extended: false }));
  app.use(express.json());

  // app.use(session({ secret: process.env.SESSIONSuperSecret as string }));

  // Auth Middleware
  // app.use(passport.initialize());
  // app.use(passport.session());
  // passport.serializeUser((user, done) => {
  //   done(null, user);
  // });

  // passport.deserializeUser((user, done) => {
  //   done(null, user);
  // });

  app.use('/api/v1', signUpRouter(database));
  app.use('/api/v1', logInRouter);
  return app;
};

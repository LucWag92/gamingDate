import express from 'express';
import helmet from 'helmet';

// ===== JWT with passport
// ***** DOCS: https://medium.com/swlh/everything-you-need-to-know-about-the-passport-jwt-passport-js-strategy-8b69f39014b0
import passport from 'passport';
import passportStart from '../Auth/passportConfig';

// ===== Routes
import signUpRouter from '../Routes/signup_route';
import logInRouter from '../Routes/login_route';
import testRouter from '../Routes/test_route';
// ===== Utils
import IDatabase from '../database/database';

export default (database: IDatabase) => {
  console.log('Server - Config Start');
  const app = express();
  // ===== Middleware
  app.use(helmet());
  app.use(express.urlencoded({ extended: false }));
  app.use(express.json());

  passportStart(passport, database);
  app.use(passport.initialize());

  app.use('/api/v1', signUpRouter(database));
  app.use('/api/v1', logInRouter(database));
  app.use('/api/v1', testRouter);
  return app;
};

import { Router } from 'express';
import passport from 'passport';

const testRouter = Router();

testRouter.get(
  '/test',

  passport.authenticate('jwt', { session: false, failWithError: true }),
  (req, res, next) => {
    console.log('--- Route: /test');
    res.status(200).json({
      success: true,
      msg: 'You are successfully authenticated to this route!',
    });
  }
);

export default testRouter;

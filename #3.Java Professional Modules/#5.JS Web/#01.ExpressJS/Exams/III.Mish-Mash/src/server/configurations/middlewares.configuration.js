import Express from 'express'
import { body as Body, check as Check, param as Param } from 'express-validator'
import UserRequestValidators from '../web/validators/user.request.validators'
import UserAttacherMiddleware from '../web/middlewares/user.attacher.middleware'
import LoggedInMiddleware from '../web/middlewares/logged.in.middleware'
import ValidationResponseMiddleware from '../web/middlewares/validation.response.middleware'
import LoggedOutMiddleware from '../web/middlewares/logged.out.middleware'
import {
  UserRoutingURLs
} from '../constants/web/routing.urls.constants'
import BaseRequestValidators from '../web/validators/base.request.validators'

const MiddlewaresConfiguration = (app) => {
  const Router = Express.Router()

  Router.all('*', UserAttacherMiddleware(app))

  /*Authentication*/

  Router.get(UserRoutingURLs.LOGIN,
    LoggedOutMiddleware
  )

  Router.post(UserRoutingURLs.LOGIN,
    LoggedOutMiddleware,
    Body()
      .custom(UserRequestValidators.credentialsValid('username', 'password')).bail(),
    ValidationResponseMiddleware
  )

  Router.get(UserRoutingURLs.REGISTER,
    LoggedOutMiddleware
  )

  Router.post(UserRoutingURLs.REGISTER,
    LoggedOutMiddleware,
    Body()
      .custom(BaseRequestValidators.notEmpty('username')).bail()
      .custom(BaseRequestValidators.notEmpty('password')).bail()
      .custom(BaseRequestValidators.notEmpty('email')).bail()
      .custom(UserRequestValidators.usernameNotPresent('username')).bail()
      .custom(UserRequestValidators.emailNotPresent('email')).bail()
      .custom(UserRequestValidators.passwordsMustMatch('password','confirmPassword')).bail(),
    ValidationResponseMiddleware
  )

  Router.get(UserRoutingURLs.LOGOUT, LoggedInMiddleware)

  return Router
}

export default MiddlewaresConfiguration
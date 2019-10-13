import Express from 'express'
import { body as Body, check as Check, param as Param } from 'express-validator'
import UserRequestValidators from '../web/validators/user.request.validators'
import UserAttacherMiddleware from '../web/middlewares/user.attacher.middleware'
import LoggedInMiddleware from '../web/middlewares/logged.in.middleware'
import ValidationResponseMiddleware from '../web/middlewares/validation.response.middleware'
import LoggedOutMiddleware from '../web/middlewares/logged.out.middleware'
import {
  ProjectRoutingURLs,
  TeamRoutingURLs,
  UserRoutingURLs
} from '../constants/web/routing.urls.constants'
import RoleMiddleware from '../web/middlewares/role.middleware'
import Roles from '../domain/models/enums/role.enums'
import BaseRequestValidators from '../web/validators/base.request.validators'
import TeamRequestValidators from '../web/validators/team.request.validators'
import ProjectRequestValidators from '../web/validators/project.request.validators'

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
      .custom(BaseRequestValidators.notEmpty('firstName')).bail()
      .custom(BaseRequestValidators.notEmpty('lastName')).bail()
      .custom(UserRequestValidators.usernameNotPresent('username')).bail(),
    ValidationResponseMiddleware
  )

  Router.post(UserRoutingURLs.LOGOUT, LoggedInMiddleware)

  /*--- TEAM ---*/

  Router.get(TeamRoutingURLs.CREATE,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN)
  )

  Router.post(TeamRoutingURLs.CREATE,
    LoggedInMiddleware,
    Body()
      .custom(TeamRequestValidators.nameNotPresent('name')).bail(),
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
  )

  Router.get(TeamRoutingURLs.ALL,
    LoggedInMiddleware
  )

  Router.post(TeamRoutingURLs.ASSIGN,
    LoggedInMiddleware,
    Body()
      .custom(TeamRequestValidators.userNotAssigned('user','team')).bail(),
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
  )

  /*--- PROJECT ---*/

  Router.get(ProjectRoutingURLs.CREATE,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN)
  )

  Router.post(ProjectRoutingURLs.CREATE,
    LoggedInMiddleware,
    Body()
      .custom(ProjectRequestValidators.nameNotPresent('name')).bail()
      .custom(BaseRequestValidators.notEmpty('name')).bail()
      .custom(BaseRequestValidators.notEmpty('description')).bail(),
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
  )

  Router.get(ProjectRoutingURLs.ALL,
    LoggedInMiddleware
  )

  Router.post(ProjectRoutingURLs.ASSIGN,
    LoggedInMiddleware,
    Body()
      .custom(ProjectRequestValidators.projectNotAssigned('project','team')).bail(),
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
  )

  return Router
}

export default MiddlewaresConfiguration
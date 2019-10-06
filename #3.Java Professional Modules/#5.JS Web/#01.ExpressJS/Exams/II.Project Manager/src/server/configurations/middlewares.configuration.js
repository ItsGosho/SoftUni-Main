import Express from 'express';
import {body as Body, check as Check, param as Param} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";
import UserAttacherMiddleware from "../web/middlewares/user.attacher.middleware";
import LoggedInMiddleware from "../web/middlewares/logged.in.middleware";
import ValidationResponseMiddleware from "../web/middlewares/validation.response.middleware";
import LoggedOutMiddleware from "../web/middlewares/logged.out.middleware";
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

const Router = Express.Router();

Router.all('*', UserAttacherMiddleware);


/*Authentication*/

Router.get(UserRoutingURLs.LOGIN,
  LoggedOutMiddleware
);

Router.post(UserRoutingURLs.LOGIN,
    LoggedOutMiddleware,
    Body()
        .custom(UserRequestValidators.credentialsValid('username', 'password')).bail(),
    ValidationResponseMiddleware
);

Router.get(UserRoutingURLs.REGISTER,
  LoggedOutMiddleware
);

Router.post(UserRoutingURLs.REGISTER,
    LoggedOutMiddleware,
    Body()
        .custom(BaseRequestValidators.notEmpty('username')).bail()
        .custom(BaseRequestValidators.notEmpty('password')).bail()
        .custom(BaseRequestValidators.notEmpty('confirmPassword')).bail()
        .custom(UserRequestValidators.usernameNotPresent('username')).bail()
        .custom(UserRequestValidators.passwordsMustMatch('password', 'confirmPassword')).bail(),
    ValidationResponseMiddleware
);

Router.post(UserRoutingURLs.LOGOUT, LoggedInMiddleware);

/*--- TEAM ---*/

Router.get(TeamRoutingURLs.CREATE,
  LoggedInMiddleware,
  RoleMiddleware(Roles.ADMIN)
);

Router.post(TeamRoutingURLs.CREATE,
  LoggedInMiddleware,
  Body()
    .custom(TeamRequestValidators.nameNotPresent('name')).bail(),
  RoleMiddleware(Roles.ADMIN)
);

Router.get(TeamRoutingURLs.ALL,
  LoggedInMiddleware
);

/*--- PROJECT ---*/

Router.get(ProjectRoutingURLs.CREATE,
  LoggedInMiddleware,
  RoleMiddleware(Roles.ADMIN)
);

Router.post(ProjectRoutingURLs.CREATE,
  LoggedInMiddleware,
  Body()
    .custom(ProjectRequestValidators.nameNotPresent('name')).bail(),
  RoleMiddleware(Roles.ADMIN)
);

Router.get(ProjectRoutingURLs.ALL,
  LoggedInMiddleware
);


export default Router;
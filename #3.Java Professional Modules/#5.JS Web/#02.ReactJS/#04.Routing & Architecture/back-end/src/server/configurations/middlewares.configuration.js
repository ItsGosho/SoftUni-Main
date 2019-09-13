import Express from 'express';
import ValidationResponseMiddleware from "../web/middlewares/validation.response.middleware";
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';
import {body as Body} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";
import {UserRoutingURLs} from '../constants/web/routing.urls';
import {UserRequestValidationRestrictionConstants} from "../constants/web/request.validation.constants";

const Router = Express.Router();

Router.all('*', UserAttacher);

/*Authentication*/
Router.all(UserRoutingURLs.LOGIN, LoggedOut,
    Body()
        .custom(UserRequestValidators.usernamePresent('username')).bail()
        .custom(UserRequestValidators.usernameLength('username', UserRequestValidationRestrictionConstants.USERNAME_MIN_LENGTH, UserRequestValidationRestrictionConstants.USERNAME_MAX_LENGTH)).bail()
    , ValidationResponseMiddleware
);
Router.all(UserRoutingURLs.REGISTER, LoggedOut,
    Body()
        .custom(UserRequestValidators.usernameNotPresent('username')).bail()
        .custom(UserRequestValidators.emailNotPresent('email')).bail()
        .custom(UserRequestValidators.passwordsMustMatch('password', 'confirmPassword')).bail()
        .custom(UserRequestValidators.email('email')).bail(),
    ValidationResponseMiddleware);


export default Router;
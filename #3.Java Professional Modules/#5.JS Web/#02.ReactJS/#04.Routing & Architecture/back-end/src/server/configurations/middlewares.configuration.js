import Express from 'express';
import AfterResponseMidddleware from "../web/middlewares/after.response.midddleware";
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
Router.all(UserRoutingURLs.LOGIN, LoggedOut);
Router.all(UserRoutingURLs.REGISTER, LoggedOut);

Router.all(
    '/test',
    Body()
        .custom(UserRequestValidators.usernamePresent('username')).bail()
        .custom(UserRequestValidators.usernameLength('username',UserRequestValidationRestrictionConstants.USERNAME_MIN_LENGTH,UserRequestValidationRestrictionConstants.USERNAME_MAX_LENGTH)).bail()
        .custom(UserRequestValidators.passwordsMustMatch('password', 'confirmPassword')).bail()
    , AfterResponseMidddleware
);

export default Router;
import Express from 'express';
import RoutingURLs from '../constants/routing.urls';
import AfterResponseMidddleware from "../web/middlewares/after.response.midddleware";
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';
import {body as Body} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";

const Router = Express.Router();

Router.all('*', UserAttacher);

/*Authentication*/
Router.all(RoutingURLs.USER.LOGIN, LoggedOut);
Router.all(RoutingURLs.USER.REGISTER, LoggedOut);

Router.all(
    '/test',
    Body()
        .custom(UserRequestValidators.usernamePresent('username')).bail()
        .custom(UserRequestValidators.passwordsMustMatch('password','confirmPassword')).bail()
    , AfterResponseMidddleware
);

export default Router;
import Express from 'express';
import RoutingURLs from '../constants/routing.urls';
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';
import UserRequestValidators from "../web/validators/user.request.validators";

const {
    check: Check,
    validationResult: ValidationResult,
    body: Body,
    query: Query,
} = require('express-validator');

const Router = Express.Router();

Router.all('*', UserAttacher);

/*Authentication*/
Router.all(RoutingURLs.USER.LOGIN, LoggedOut);
Router.all(RoutingURLs.USER.REGISTER, LoggedOut);

Router.all('/test',
    Body()
        .custom(UserRequestValidators.usernamePresent).bail()
        .custom(UserRequestValidators.passwordsMustMatch).bail(),
    (request, response, next) => {
        const errors = ValidationResult(request);
        if (!errors.isEmpty()) {
            return response.status(400).json({errors: errors.array()});
        }
        next();
    }
);

export default Router;
import Express from 'express';
import {body as Body, check as Check} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";
import UserAttacherMiddleware from "../web/middlewares/user.attacher.middleware";
import LoggedInMiddleware from "../web/middlewares/logged.in.middleware";
import ValidationResponseMiddleware from "../web/middlewares/validation.response.middleware";
import LoggedOutMiddleware from "../web/middlewares/logged.out.middleware";
import {BookRoutingURLs, UserRoutingURLs} from "../constants/web/routing.urls.constants";
import RoleMiddleware from "../web/middlewares/role.middleware";
import Roles from "../domain/models/enums/role.enums";
import BookRequestValidators from "../web/validators/book.request.validators";

const Router = Express.Router();

Router.all('*', UserAttacherMiddleware);


/*Authentication*/
Router.post(UserRoutingURLs.LOGIN,
    LoggedOutMiddleware,
    Body()
        .custom(UserRequestValidators.credentialsValid('username', 'password')).bail(),
    ValidationResponseMiddleware
);

Router.post(UserRoutingURLs.REGISTER,
    LoggedOutMiddleware,
    Body()
        .custom(UserRequestValidators.usernameNotPresent('username')).bail()
        .custom(UserRequestValidators.emailNotPresent('email')).bail()
        .custom(UserRequestValidators.passwordsMustMatch('password', 'confirmPassword')).bail()
        .custom(UserRequestValidators.email('email')).bail(),
    ValidationResponseMiddleware
);

Router.post(UserRoutingURLs.LOGOUT, LoggedInMiddleware);

Router.post(BookRoutingURLs.CREATE,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    Body()
        .custom(BookRequestValidators.titleNotPresent('title')).bail()
        .custom(BookRequestValidators.titleLengthValid('title')).bail()
        .custom(BookRequestValidators.descriptionLengthValid('description')).bail()
        .custom(BookRequestValidators.priceValid('price')).bail()
        .custom(BookRequestValidators.imageValid('image')).bail(),
    ValidationResponseMiddleware
);


export default Router;
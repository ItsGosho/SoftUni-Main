import Express from 'express';
import {body as Body, check as Check} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";
import UserAttacherMiddleware from "../web/middlewares/user.attacher.middleware";
import RoleMiddleware from "../web/middlewares/role.middleware";
import LoggedInMiddleware from "../web/middlewares/logged.in.middleware";
import ValidationResponseMiddleware from "../web/middlewares/validation.response.middleware";
import LoggedOutMiddleware from "../web/middlewares/logged.out.middleware";
import {UserRoutingURLs, MovieRoutingURLs} from "../constants/web/routing.urls";
import {
    MovieRequestValidationMessagesConstants,
    MovieRequestValidationRestrictionConstants,
    UserRequestValidationRestrictionConstants
} from "../constants/web/request.validation.constants";
import ROLE from "../domain/models/enums/role.enums";

const Router = Express.Router();

Router.all('*', UserAttacherMiddleware);


/*Authentication*/
Router.post(UserRoutingURLs.LOGIN,
    [
        LoggedOutMiddleware,
        Body()
            .custom(UserRequestValidators.usernamePresent('username')).bail()
            .custom(UserRequestValidators.usernameLength('username', UserRequestValidationRestrictionConstants.USERNAME_MIN_LENGTH, UserRequestValidationRestrictionConstants.USERNAME_MAX_LENGTH)).bail()
        , ValidationResponseMiddleware
    ]);

Router.post(UserRoutingURLs.REGISTER,
    [LoggedOutMiddleware,
        Body()
            .custom(UserRequestValidators.usernameNotPresent('username')).bail()
            .custom(UserRequestValidators.emailNotPresent('email')).bail()
            .custom(UserRequestValidators.passwordsMustMatch('password', 'confirmPassword')).bail()
            .custom(UserRequestValidators.email('email')).bail(),
        ValidationResponseMiddleware
    ]);

Router.post(MovieRoutingURLs.CREATE,
    [LoggedInMiddleware,
        RoleMiddleware(ROLE.ADMIN),
        Check('title').isLength(MovieRequestValidationRestrictionConstants.TITLE_MIN_LENGTH),
        Check('storyLine').isLength(MovieRequestValidationRestrictionConstants.STORYLINE_MIN_LENGTH),
        Check('trailerUrl').isURL().withMessage(MovieRequestValidationMessagesConstants.TRAILER_URL_NOT_VALID),
        Check('poster').isURL().withMessage(MovieRequestValidationMessagesConstants.POSTER_URL_NOT_VALID),
        ValidationResponseMiddleware
    ]);


export default Router;
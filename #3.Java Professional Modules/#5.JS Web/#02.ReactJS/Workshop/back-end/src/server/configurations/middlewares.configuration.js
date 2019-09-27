import Express from 'express';
import {body as Body, check as Check, param as Param} from 'express-validator';
import UserRequestValidators from "../web/validators/user.request.validators";
import UserAttacherMiddleware from "../web/middlewares/user.attacher.middleware";
import LoggedInMiddleware from "../web/middlewares/logged.in.middleware";
import ValidationResponseMiddleware from "../web/middlewares/validation.response.middleware";
import LoggedOutMiddleware from "../web/middlewares/logged.out.middleware";
import {
    BookRoutingURLs,
    OrderRoutingURLs,
    StatisticsRoutingURLs,
    UserRoutingURLs
} from "../constants/web/routing.urls.constants";
import RoleMiddleware from "../web/middlewares/role.middleware";
import Roles from "../domain/models/enums/role.enums";
import BookRequestValidators from "../web/validators/book.request.validators";
import OrderRequestValidators from "../web/validators/order.request.validators";

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

Router.post(BookRoutingURLs.EDIT,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    Param()
        .custom(BookRequestValidators.bookPresent('id')).bail(),
    Body()
        .custom(BookRequestValidators.titleNotPresent('title')).bail()
        .custom(BookRequestValidators.titleLengthValid('title')).bail()
        .custom(BookRequestValidators.descriptionLengthValid('description')).bail()
        .custom(BookRequestValidators.priceValid('price')).bail()
        .custom(BookRequestValidators.imageValid('image')).bail(),
    ValidationResponseMiddleware
);

Router.post(BookRoutingURLs.DELETE,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    Param()
        .custom(BookRequestValidators.bookPresent('id')).bail(),
    ValidationResponseMiddleware
);

Router.post(BookRoutingURLs.REVIEW,
    LoggedInMiddleware,
    Param()
        .custom(BookRequestValidators.bookPresent('id')).bail(),
    Body()
        .custom(BookRequestValidators.reviewLengthValid('review')).bail(),
    ValidationResponseMiddleware
);

Router.post(BookRoutingURLs.LIKE,
    LoggedInMiddleware,
    Param()
        .custom(BookRequestValidators.bookPresent('id')).bail()
        .custom(BookRequestValidators.notLikedByCurrentUser('id')).bail(),
    ValidationResponseMiddleware
);

Router.post(BookRoutingURLs.UNLIKE,
    LoggedInMiddleware,
    Param()
        .custom(BookRequestValidators.bookPresent('id')).bail()
        .custom(BookRequestValidators.likedByCurrentUser('id')).bail(),
    ValidationResponseMiddleware
);

Router.post(OrderRoutingURLs.CREATE,
    LoggedInMiddleware,
    Body()
        .custom(BookRequestValidators.booksExist('books')).bail(),
    ValidationResponseMiddleware
);

Router.get(OrderRoutingURLs.MY,
    LoggedInMiddleware
);

Router.get(OrderRoutingURLs.ALL,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN)
);

Router.post(OrderRoutingURLs.APPROVE,
    LoggedInMiddleware,
    Param()
        .custom(OrderRequestValidators.orderPresent('id')).bail()
        .custom(OrderRequestValidators.orderNotApproved('id')).bail(),
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
);

Router.get(StatisticsRoutingURLs.TOTAL_USERS,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
);

Router.get(StatisticsRoutingURLs.TOTAL_BOOKS,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
);


Router.get(StatisticsRoutingURLs.TOTAL_ORDERS,
    LoggedInMiddleware,
    RoleMiddleware(Roles.ADMIN),
    ValidationResponseMiddleware
);


export default Router;
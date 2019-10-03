import Express from 'express';
import RoutingURLs from '../constants/routing.urls';
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';
import Role from '../web/middlewares/role.middleware';
import Roles from '../domain/models/enums/role.enums';


const Router = Express.Router();

Router.all('*', UserAttacher);

/*Authentication*/
Router.all(RoutingURLs.USER.LOGIN, LoggedOut);
Router.all(RoutingURLs.USER.REGISTER, LoggedOut);
Router.all(RoutingURLs.USER.LOGOUT, JWTTokenValidator);

/*Course*/
Router.all(RoutingURLs.COURSE.CREATE, JWTTokenValidator, Role(Roles.ADMIN));
Router.all(RoutingURLs.COURSE.EDIT, JWTTokenValidator, Role(Roles.ADMIN));
Router.all(RoutingURLs.COURSE.DETAILS, JWTTokenValidator, Role(Roles.USER));
Router.all(RoutingURLs.COURSE.ENROLL, JWTTokenValidator, Role(Roles.USER));

/*Lecture*/
Router.all(RoutingURLs.LECTURE.PANEL, JWTTokenValidator, Role(Roles.ADMIN));
Router.all(RoutingURLs.LECTURE.ADD, JWTTokenValidator, Role(Roles.ADMIN));
Router.all(RoutingURLs.LECTURE.DELETE, JWTTokenValidator, Role(Roles.ADMIN));
Router.all(RoutingURLs.LECTURE.PLAY, JWTTokenValidator, Role(Roles.USER));

export default Router;
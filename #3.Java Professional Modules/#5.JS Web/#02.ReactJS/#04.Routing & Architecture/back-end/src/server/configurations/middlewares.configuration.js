import Express from 'express';
import RoutingURLs from '../constants/routing.urls';
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';


const Router = Express.Router();

Router.all('*', UserAttacher);

/*Authentication*/
Router.all(RoutingURLs.USER.LOGIN, LoggedOut);
Router.all(RoutingURLs.USER.REGISTER, LoggedOut);

export default Router;
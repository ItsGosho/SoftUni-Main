import Express from 'express';
import RoutingURLs from '../constants/routing.urls';
import JWTTokenValidator from '../web/middlewares/jwt.token.middleware';
import UserAttacher from '../web/middlewares/user.attacher.middleware';
import LoggedOut from '../web/middlewares/logged.out.middleware';


const Router = Express.Router();

Router.all('*', UserAttacher);

/*Category*/
Router.all(RoutingURLs.CATEGORY.CREATE, JWTTokenValidator);
Router.all(RoutingURLs.CATEGORY.ALL_PRODUCT_BY_CATEGORY, JWTTokenValidator);

/*Product*/
Router.all(RoutingURLs.PRODUCT.ADD, JWTTokenValidator);
Router.all(RoutingURLs.PRODUCT.EDIT, JWTTokenValidator);
Router.all(RoutingURLs.PRODUCT.BUY, JWTTokenValidator);
Router.all(RoutingURLs.PRODUCT.DELETE, JWTTokenValidator);

/*Authentication*/
Router.all(RoutingURLs.USER.LOGIN, LoggedOut);
Router.all(RoutingURLs.USER.REGISTER, LoggedOut);

export default Router;
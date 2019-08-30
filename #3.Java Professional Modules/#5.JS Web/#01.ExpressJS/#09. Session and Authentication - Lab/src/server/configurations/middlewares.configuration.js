const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

const JWTTokenValidator = require('../web/middlewares/jwt.token.middleware');
const UserAttacher = require('../web/middlewares/user.attacher.middleware');
const LoggedOut = require('../web/middlewares/logged.out.middleware');


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
Router.all(RoutingURLs.USER.LOGIN,LoggedOut);
Router.all(RoutingURLs.USER.REGISTER,LoggedOut);

module.exports = Router;
const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const Roles = require('../domain/models/enums/role.enums');

const JWTTokenValidator = require('../web/middlewares/jwt.token.middleware');
const Role = require('../web/middlewares/role.middleware');
const UserAttacher = require('../web/middlewares/user.attacher.middleware');
const LoggedOut = require('../web/middlewares/logged.out.middleware');


Router.all('*', UserAttacher);

/*Category*/
Router.all(RoutingURLs.CATEGORY.CREATE,JWTTokenValidator,Role(Roles.ADMIN));
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
const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const ProductServices = require('../../services/product.services');
const ViewPaths = require('../../constants/view.path.constants');
const Role = require('../middlewares/role.middleware');
const JWTMiddleware = require('../middlewares/jwt.token.middleware');

Router.get(RoutingURLs.BASE.HOME, JWTMiddleware, async (request, response) => {
    let products = await ProductServices.findAll();

    response.render(ViewPaths.OTHER.HOME, {products});
});


module.exports = Router;
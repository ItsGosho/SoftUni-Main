const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const CategoryServices = require('../../services/category.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.USER.LOGIN_GET, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.LOGIN);
});

Router.get(RoutingURLs.USER.REGISTER_GET, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.REGISTER);
});

module.exports = Router;
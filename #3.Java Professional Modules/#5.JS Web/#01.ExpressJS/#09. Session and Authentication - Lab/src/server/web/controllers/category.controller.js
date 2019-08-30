const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const CategoryServices = require('../../services/category.services');
const ViewPaths = require('../../constants/view.path.constants');

const Role = require('../middlewares/role.middleware');
const JWTToken = require('../middlewares/jwt.token.middleware');

Router.get(RoutingURLs.CATEGORY.CREATE, (request, response) => {
    response.render(ViewPaths.CATEGORY.CREATE_CATEGORY, {user: request.user});
});

Router.post(RoutingURLs.CATEGORY.CREATE,async (request, response) => {
    let category = {
        name: request.body.name
    };

    await CategoryServices.save(category);
    response.redirect(RoutingURLs.HOME);
});

module.exports = Router;
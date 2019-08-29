const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const CategoryServices = require('../../services/category.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.CATEGORY.CREATE_GET, (request, response) => {
    response.render(ViewPaths.CATEGORY.CREATE_CATEGORY, {});
});

Router.post(RoutingURLs.CATEGORY.CREATE_POST, (request, response) => {
    let category = {
        name: request.body.name
    };

    CategoryServices.save(category, (error, category) => {
    });
    response.redirect(RoutingURLs.HOME);
});

module.exports = Router;
const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const CategoryServices = require('../services/category.services');
const ViewPaths = require('../constants/view.path.constants');


Router.route(RoutingURLs.CATEGORY_CREATE)
    .get((request, response) => {
        response.render(ViewPaths.CATEGORY.CREATE_CATEGORY, {});
    })
    .post((request, response) => {

        let category = {
            name: request.body.name
        };

        CategoryServices.save(category,(error,category)=>{});
        response.redirect(RoutingURLs.HOME);
    });

module.exports = Router;
const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const CategoryServices = require('../services/category.services');


Router.route(RoutingURLs.CREATE_CATEGORY)
    .get((request, response) => {
        response.render('category/create-category', {});
    })
    .post((request, response) => {

        let category = {
            name: request.body.name
        };

        CategoryServices.save(category,(error,category)=>{});
        response.redirect(RoutingURLs.HOME);
    });

module.exports = Router;
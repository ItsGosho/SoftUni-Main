const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const ProductServices = require('../services/product.services');

Router.route(RoutingURLs.HOME)
    .get((request, response) => {
        ProductServices.findAll((e, products) => {
            response.render('home/index', {products});
        })
    });

module.exports = Router;
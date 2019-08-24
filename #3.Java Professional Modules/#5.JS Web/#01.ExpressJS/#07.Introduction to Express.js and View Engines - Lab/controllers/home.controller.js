const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const ProductServices = require('../services/product.services');
const CategoryServices = require('../services/category.services');

Router.route(RoutingURLs.HOME)
    .get(async (request, response) => {
        let products = await ProductServices.findAll();

        response.render('layouts/home/home', {products});
    });

Router.route(RoutingURLs.CATEGORY_VIEW_ALL_PRODUCTS)
    .get(async (request, response) => {
        let category = await CategoryServices.findByName(request.params.category);
        let products = await ProductServices.findAllByCategory(category.id);

        response.render('layouts/category/category-products', {products,category});
    });

module.exports = Router;
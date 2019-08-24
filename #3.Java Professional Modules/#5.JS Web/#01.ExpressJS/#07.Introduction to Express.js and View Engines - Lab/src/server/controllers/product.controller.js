const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const ProductServices = require('../services/product.services');
const CategoryServices = require('../services/category.services');
const ViewPaths = require('../constants/view.path.constants');

Router.route(RoutingURLs.CREATE_PRODUCT)
    .get(async (request, response) => {
        let categories = await CategoryServices.findAll();

        response.render(ViewPaths.PRODUCT.CREATE_PRODUCT, {categories});
    })
    .post((request, response) => {

        let {name, description, price, category} = request.body;

        ProductServices.uploadImage(request.files.image, (path) => {
            let product = {
                name: name,
                description: description,
                price: price,
                category: category,
                image: path
            };

            ProductServices.save(product, (e, result) => {
                CategoryServices.addProduct(result.category, result._id);
                response.redirect(RoutingURLs.HOME);
            });
        });

    });

Router.route(RoutingURLs.ALL_PRODUCT_BY_CATEGORY)
    .get(async (request, response) => {
        let category = await CategoryServices.findByName(request.params.category);
        let products = await ProductServices.findAllByCategory(category.id);

        response.render(ViewPaths.CATEGORY.CATEGORY_PRODUCTS, {products, category});
    });

Router.route(RoutingURLs.EDIT_PRODUCT_GET)
    .get(async (request, response) => {
        let productId = request.params.id;
        let product = await ProductServices.findById(productId);
        let categories = await CategoryServices.findAll();

        response.render(ViewPaths.PRODUCT.EDIT_PRODUCT, {product, categories});
    });

Router.route(RoutingURLs.DELETE_PRODUCT_GET)
    .get(async (request, response) => {
        let productId = request.params.id;
        let product = await ProductServices.findById(productId);

        response.render(ViewPaths.PRODUCT.DELETE_PRODUCT, {product});
    });

Router.route(RoutingURLs.BUY_PRODUCT_GET)
    .get(async (request, response) => {
        let productId = request.params.id;
        let product = await ProductServices.findById(productId);

        response.render(ViewPaths.PRODUCT.BUY_PRODUCT, {product});
    });

module.exports = Router;
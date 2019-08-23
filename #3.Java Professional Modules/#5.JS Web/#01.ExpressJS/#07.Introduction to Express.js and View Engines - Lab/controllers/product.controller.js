const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const ProductServices = require('../services/product.services');
const CategoryServices = require('../services/category.services');

Router.route(RoutingURLs.PRODUCT_ADD)
    .get((request, response) => {

        CategoryServices.findAll((error, categories) => {
            response.render('product/create-product', {categories});
        });
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

module.exports = Router;
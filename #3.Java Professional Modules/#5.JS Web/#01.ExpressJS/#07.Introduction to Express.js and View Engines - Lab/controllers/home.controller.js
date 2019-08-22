const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

const Product = require('../schemas/product');

Router.route(RoutingURLs.HOME)
    .get((request, response) => {

        response.render('home/index',{});

       /* Product.find().then((products) => {
            //TODO:
        });*/

    });

module.exports = Router;
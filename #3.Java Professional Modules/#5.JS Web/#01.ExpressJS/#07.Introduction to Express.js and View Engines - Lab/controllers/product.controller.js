const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

Router.route(RoutingURLs.PRODUCT_ADD)
    .get((request, response) => {
        response.send('Create product GET!');
    })
    .post((request, response) => {
        response.send('Create product POST!');
    });

module.exports = Router;
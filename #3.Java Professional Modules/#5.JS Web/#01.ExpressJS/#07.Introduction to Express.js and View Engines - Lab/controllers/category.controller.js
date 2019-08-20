const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

Router.route(RoutingURLs.CREATE_CATEGORY)
    .get((request, response) => {
        response.send('Create category GET!');
    })
    .post((request, response) => {
        response.send('Create category POST!');
    });

module.exports = Router;
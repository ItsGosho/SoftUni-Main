const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

Router.route(RoutingURLs.HOME)
    .get((request, response) => {
        response.send('Home!');
    });

module.exports = Router;
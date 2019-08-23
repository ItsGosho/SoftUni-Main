const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const ProductServices = require('../services/product.services');
const DropboxServices = require('../services/dropbox.services');

Router.route(RoutingURLs.HOME)
    .get((request, response) => {
        ProductServices.findAll(async (e, products) => {

            for (const product of products) {
                let data = await DropboxServices.downloadFile(product.image);
                product.image = 'data:image/jpeg;base64, ' + Buffer.from(data.fileBinary).toString('base64')
            }

            response.render('home/index', {products});
        })
    });

module.exports = Router;
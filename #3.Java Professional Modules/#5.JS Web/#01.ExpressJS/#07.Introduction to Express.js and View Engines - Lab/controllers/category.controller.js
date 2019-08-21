const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');

const MultiParty = require('multiparty');
const QueryString = require('querystring');
const ShortID = require('shortid');
const Category = require('../models/category');

Router.route(RoutingURLs.CREATE_CATEGORY)
    .get((request, response) => {
        response.render('category/create-category',{});
    })
    .post((request, response) => {

        let dataString = '';
        request.on('data', (data) => {
            dataString += data;
        });

        request.on('end', () => {
            let category = QueryString.parse(dataString);
            Category.create(category).then(()=>{
                console.log('Category created!');
            });

            response.redirect('/')
        });
    });

module.exports = Router;
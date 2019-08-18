const RequestMethod = require('../constants/method.types');
const URLConstants = require('../constants/routing.urls');


const URL = require('url');
const FileSystem = require('fs');
const Base64Image = require('base64-img');
const Path = require('path');
const Product = require('../models/product');


/**
 *
 * @param {module:http.IncomingMessage} request
 * @param {module:http.ServerResponse} response
 *
 * */
module.exports = (request, response) => {

    let requestedUrl = URL.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URLConstants.HOME && request.method === RequestMethod.GET) {

        let resourcePath = (Path.join(__dirname, '../views/home/index.html'));


        let asd;
        let append = '';
        FileSystem.readFile(resourcePath, (err, data) => {

            Product.find().then((products) => {
                for (let product of products) {

                    append += `
                <div class="product-card">
                  <img class="product-img" src="${Base64Image.base64Sync(product.image)}">
                  <h2>${product.name}</h2>
                  <p>${product.description}</p>
                </div>
            `;
                }

                data = data.toString().replace('${content}', append);
                response.write(data);
                response.end();
            });
        })


    } else {
        return true;
    }
};
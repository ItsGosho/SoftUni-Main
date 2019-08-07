const RequestMethod = require('../constants/method.types');
const URL = require('../constants/routing.urls');
const Database = require('../config/database');


const urlLibrary = require('url');
const fileSystemLibrary = require('fs');
const pathLibrary = require('path');

module.exports = (request, response) => {

    let requestedUrl = urlLibrary.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URL.HOME && request.method === RequestMethod.GET) {

        let resourcePath = (pathLibrary.join(__dirname, '../views/home/index.html'));


        let append = '';
        fileSystemLibrary.readFile(resourcePath, (err, data) => {

            for (let product of Database.getAll()) {
                append += `
                <div class="product-card">
                  <img class="product-img" src="${product.image}">
                  <h2>${product.name}</h2>
                  <p>${product.description}</p>
                </div>
            `;

            }

            data = data.toString().replace('${content}', append);
            response.write(data);
            response.end();
        })


    } else {
        return true;
    }
};
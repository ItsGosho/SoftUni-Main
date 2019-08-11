const RequestMethod = require('../constants/method.types');
const URL = require('../constants/routing.urls');
const Storage = require('../tools/storage');


const urlLibrary = require('url');
const FileSystem = require('fs');
const Base64Image = require('base64-img');
const Path = require('path');

module.exports = (request, response) => {

    let requestedUrl = urlLibrary.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URL.HOME && request.method === RequestMethod.GET) {

        let resourcePath = (Path.join(__dirname, '../views/home/index.html'));


        let append = '';
        FileSystem.readFile(resourcePath, (err, data) => {


            for (let product of Storage.getProducts()) {

                append += `
                <div class="product-card">
                  <img class="product-img" src="${Base64Image.base64Sync(product.imagePath)}">
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
const RequestMethod = require('../constants/method.types');
const URL = require('../constants/routing.urls');
const Database = require('../config/database');

const urlLibrary = require('url');
const fileSystemLibrary = require('fs');
const queryStringLibrary = require('querystring');
const pathLibrary = require('path');

module.exports = (request, response) => {

    let requestedUrl = urlLibrary.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URL.PRODUCT_ADD && request.method === RequestMethod.GET) {

        let resourcePath = (pathLibrary.join(__dirname, '../views/product/create-product.html'));
        const readStream = fileSystemLibrary.createReadStream(resourcePath);

        readStream.on('error', (error) => {
            console.log('Error');
        });

        readStream.pipe(response);

    } else if (pathname === URL.PRODUCT_ADD && request.method === RequestMethod.POST) {

        let dataString = '';
        request.on('data', (data) => {
            dataString += data;
        });

        request.on('end', () => {
            let product = queryStringLibrary.parse(dataString);
            Database.add(product);

            console.log();
        });

        response.writeHead(302, {
            'Location': '/'
        });

        response.end();


    } else {
        return true;
    }
};
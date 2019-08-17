const RequestMethod = require('../constants/method.types');
const URLConstants = require('../constants/routing.urls');

const URL = require('url');
const FileSystem = require('fs');
const Path = require('path');
const MultiParty = require('multiparty');
const QueryString = require('querystring');
const ShortID = require('shortid');
const Category = require('../models/category');


/**
 *
 * @param {module:http.IncomingMessage} request
 * @param {module:http.ServerResponse} response
 *
 * */
module.exports = (request, response) => {

    let requestedUrl = URL.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URLConstants.CREATE_CATEGORY && request.method === RequestMethod.GET) {

        let resourcePath = (Path.join(__dirname, '../views/category/create-category.html'));
        const readStream = FileSystem.createReadStream(resourcePath);

        readStream.on('error', (error) => {
            console.log('Error');
        });

        readStream.pipe(response);

    } else if (pathname === URLConstants.CREATE_CATEGORY && request.method === RequestMethod.POST) {

        let dataString = '';
        request.on('data', (data) => {
            dataString += data;
        });

        request.on('end', () => {
            let category = QueryString.parse(dataString);
            Category.create(category).then(()=>{
                console.log('Category created!');
            });

            response.writeHead(302, {
                'Location': '/'
            });

            response.end();
        });

    } else {
        return true;
    }
};
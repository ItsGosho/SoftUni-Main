const RequestMethod = require('../constants/method.types');
const URLConstants = require('../constants/routing.urls');

const URL = require('url');
const FileSystem = require('fs');
const Path = require('path');

function isResource(url) {
    return url.startsWith('/resources/') ;
}

/**
 *
 * @param {module:http.IncomingMessage} request
 * @param {module:http.ServerResponse} response
 *
 * */
module.exports = (request, response) => {
    let requestedUrl = URL.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (isResource(pathname) && request.method === RequestMethod.GET) {

        let resourcePath = (Path.join(__dirname, `..${pathname}`));
        const readStream = FileSystem.createReadStream(resourcePath);

        readStream.on('error', (error) => {
            console.log('Error');
        });

        readStream.pipe(response);

    } else {
        return true;
    }
};
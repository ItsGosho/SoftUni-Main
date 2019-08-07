const RequestMethod = require('../constants/method.types');
const URL = require('../constants/routing.urls');

const urlLibrary = require('url');
const fileSystemLibrary = require('fs');
const pathLibrary = require('path');

function isResource(url) {
    return url.startsWith('/resources/');
}

module.exports = (request, response) => {
    let requestedUrl = urlLibrary.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (isResource(pathname) && request.method === RequestMethod.GET) {

        let resourcePath = (pathLibrary.join(__dirname, `..${pathname}`));
        const readStream = fileSystemLibrary.createReadStream(resourcePath);

        readStream.on('error', (error) => {
            console.log('Error');
        });

        readStream.pipe(response);

    } else {
        return true;
    }
};
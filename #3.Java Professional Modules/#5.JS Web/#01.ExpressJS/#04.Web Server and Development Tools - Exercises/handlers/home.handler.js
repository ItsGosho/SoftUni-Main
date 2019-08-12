const URL = require('url');
const FileSystem = require('fs');
const HTMLTools = require('../tools/html.tools');

module.exports = (request, response) => {
    if (isValid(request)) {
        let result = HTMLTools.getHTMLAsString('views/home.html');
        response.write(result);
        response.end();
    }
};

function isValid(request) {
    let url = URL.parse(request.url).pathname;
    return url === '/' && request.method.toUpperCase() === 'GET';
}
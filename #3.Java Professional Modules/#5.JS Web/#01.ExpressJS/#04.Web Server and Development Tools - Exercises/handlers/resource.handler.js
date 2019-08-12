const URL = require('url');
const FileSystem = require('fs');
const HTMLTools = require('../tools/html.tools');

module.exports = (request, response) => {
    if (isValid(request)) {
        let url = URL.parse(request.url).pathname;
        let dir = `${__rootDirectory}${url}`;

        let file = FileSystem.readFileSync(dir);
        response.write(file);
        response.end();
    }
};

function isValid(request) {
    let url = URL.parse(request.url).pathname;
    return url.startsWith('/public') &&
        (url.endsWith('.css') || url.endsWith('.ico') || url.endsWith('.png')) &&
        request.method.toUpperCase() === 'GET';
}
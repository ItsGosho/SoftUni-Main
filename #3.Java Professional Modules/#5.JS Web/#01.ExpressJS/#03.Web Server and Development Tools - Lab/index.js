const http = require('http');
const handlers = require('./handlers/handlers');

let port = 8000;

let server = http.createServer((request, response) => {

    for (let handler of handlers) {
        if (!handler(request, response)) {
            break;
        }
    }

});
server.listen(port);

console.log(`Server started on ${port}`);
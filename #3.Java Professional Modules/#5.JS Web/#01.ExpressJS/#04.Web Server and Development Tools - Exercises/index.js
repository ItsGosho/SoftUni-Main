const http = require('http');
const handlers = require('./handlers/handlers');

global.__rootDirectory = __dirname;

let passToHandler = (request, response) => {
    for (const [key, value] of Object.entries(handlers)) {
        value(request, response);
    }
};

let port = 8000;
let server = http.createServer(passToHandler);
server.listen(port);

console.log(`http://localhost:${port}`);
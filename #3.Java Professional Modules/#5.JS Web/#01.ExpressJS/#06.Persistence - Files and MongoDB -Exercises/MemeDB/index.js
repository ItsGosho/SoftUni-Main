const http = require('http');
const url = require('url');
const handlers = require('./handlers/handlers');

const Database = require('./configurations/database.configuration');
const Configuration = require('./configurations/configuration');
Database(Configuration.development);

const port = 8000;


http
    .createServer((req, res) => {
        for (let handler of handlers) {
            req.pathname = url.parse(req.url).pathname;
            let task = handler(req, res);
            if (task !== true) {
                break
            }
        }
    })
    .listen(port);
console.log('Im listening on ' + port);


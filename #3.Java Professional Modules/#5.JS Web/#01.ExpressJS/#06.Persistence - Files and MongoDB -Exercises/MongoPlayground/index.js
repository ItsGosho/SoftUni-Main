const http = require('http');
const url = require('url');
const qs = require('querystring');
const port = 8000;
const handlers = require('./handlers/handlers');

const Database = require('./configurations/database.configuration');
const Configuration = require('./configurations/configuration');
Database(Configuration.development);

http
    .createServer((req, res) => {
        req.pathname = url.parse(req.url).pathname;
        req.pathquery = qs.parse(url.parse(req.url).query);
        for (let handler of handlers) {
            if (!handler(req, res)) {
                break
            }
        }
    })
    .listen(port);
console.log('Im listening on ' + port);
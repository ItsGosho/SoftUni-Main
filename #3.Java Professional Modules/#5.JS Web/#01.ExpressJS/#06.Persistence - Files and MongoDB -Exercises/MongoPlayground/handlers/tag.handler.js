let QueryString = require('querystring');
let TagServices = require('../services/tag.services');

/**
 * @param {module:http.IncomingMessage} req
 * @param {module:http.ServerResponse} res
 * @param {String} req.pathname
 * */
module.exports = (req, res) => {
    if (req.pathname === '/generateTag' && req.method === 'POST') {
        let body = '';

        req.on('data', function (data) {
            body += data;
        });

        req.on('end', function () {
            let data = QueryString.parse(body);

            let tag = {
                name: data.tagName,
                creationDate: Date.now(),
            };

            TagServices.add(tag);
            res.writeHead(301, {
                'Location': '/'
            });
            res.end();
        });

    } else {
        return true
    }
};

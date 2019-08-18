const fs = require('fs');
const filePath = './views/home.html';
let URLs = require('../constants/url.constants');
let RequestMethods = require('../constants/request.methods.constants');


module.exports = (req, res) => {
    if (req.pathname === URLs.BASE.HOME && req.method === RequestMethods.GET) {
        fs.readFile(filePath, (err, data) => {
            if (err) {
                console.log(err)
                return
            }
            res.writeHead(200, {
                'Content-Type': 'text/html'
            });
            res.end(data)
        })
    } else {
        return true
    }
};

let QueryString = require('querystring');
let ImageServices = require('../services/image.services');
let TagServices = require('../services/tag.services');

module.exports = (req, res) => {
    if (req.pathname === '/addImage' && req.method === 'POST') {
        let body = '';

        req.on('data', function (data) {
            body += data;
        });

        req.on('end', function () {
            let data = QueryString.parse(body);

            let tags = data.tagsID.split(',');
            let image = {
                description: data.description,
                title: data.imageTitle,
                url: data.imageUrl,
                creationDate: Date.now(),
                tags: tags.slice(0, tags.length - 1),
            };

            ImageServices.add(image, (image) => {
                let tagsIds = image.tags;
                for (let tagId of tagsIds) {
                    TagServices.findById(tagId, (error, tag) => {
                        tag.images.push(image.id);
                        tag.save();
                    })
                }

                console.log();
            });

            res.writeHead(301, {
                'Location': '/'
            });
            res.end();
        });
    } else if (req.pathname === '/delete' && req.method === 'GET') {
        deleteImg(req, res)
    } else {
        return true
    }
};

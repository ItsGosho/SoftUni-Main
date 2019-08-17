const RequestMethod = require('../constants/method.types');
const URLConstants = require('../constants/routing.urls');

const URL = require('url');
const FileSystem = require('fs');
const Path = require('path');
const MultiParty = require('multiparty');
const ShortID = require('shortid');
const Product = require('../models/product');


/**
 *
 * @param {module:http.IncomingMessage} request
 * @param {module:http.ServerResponse} response
 *
 * */
module.exports = (request, response) => {

    let requestedUrl = URL.parse(request.url);
    let pathname = requestedUrl.pathname;

    if (pathname === URLConstants.PRODUCT_ADD && request.method === RequestMethod.GET) {

        let resourcePath = (Path.join(__dirname, '../views/product/create-product.html'));
        const readStream = FileSystem.createReadStream(resourcePath);

        readStream.on('error', (error) => {
            console.log('Error');
        });

        readStream.pipe(response);

    } else if (pathname === URLConstants.PRODUCT_ADD && request.method === RequestMethod.POST) {
        let form = new MultiParty.Form();
        let product = {};

        form.parse(request, function (err, fields, files) {

            let image = files.image[0];
            let extension = image.originalFilename.substr(image.originalFilename.lastIndexOf('.') + 1);
            FileSystem.readFile(image.path, (error, data) => {
                product.image = Path.join(__dirname, `../content/images/${ShortID.generate()}.${extension}`)
                FileSystem.writeFile(product.image, data, () => {
                });

                for (let [key, value] of Object.entries(fields)) {
                    product[key] = value[0];
                }

                Product.create(product).then(()=>{
                    console.log('Product saved!');
                    response.end();
                });
            });
        });

    } else {
        return true;
    }
};
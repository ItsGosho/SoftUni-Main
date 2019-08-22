const Router = require('express').Router();
const RoutingURLs = require('../constants/routing.urls');
const CategoryServices = require('../services/category.services');

Router.route(RoutingURLs.PRODUCT_ADD)
    .get((request, response) => {

        CategoryServices.findAll((error,categories)=>{
            response.render('product/create-product',{categories});
        });
    })
    .post((request, response) => {

       /* let form = new MultiParty.Form();
        let product = {};

        form.parse(request, function (err, fields, files) {

                let image = files.image[0];
                let extension = image.originalFilename.substr(image.originalFilename.lastIndexOf('.') + 1);
                FileSystem.readFile(image.path, (error, data) => {

                    product.image = Path.join(__dirname, `../content/images/${ShortID.generate()}.${extension}`);

                    FileSystem.writeFile(product.image, data, () => {
                    });

                    for (let [key, value] of Object.entries(fields)) {
                        product[key] = value[0];
                    }

                    Product.create(product).then((result) => {
                        console.log('Product saved!');

                        Categories.findById(result.category).then((category)=>{
                            console.log('Category updated!!');
                            category.products.push(result._id);
                            category.save();
                        });

                        response.writeHead(301, {'Location': '/'});
                        response.end();
                    });
                });
            }
        );
*/
    });

module.exports = Router;
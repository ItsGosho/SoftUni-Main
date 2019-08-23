const ProductSchema = require('../schemas/product');

let save = (product, callback) => {
    ProductSchema.create(product, (error, savedProduct) => {
        if (!error) {
            console.log(`Category [${savedProduct.name}] created!`);
        }

        callback(error,savedProduct);
    })
};

module.exports = {save};
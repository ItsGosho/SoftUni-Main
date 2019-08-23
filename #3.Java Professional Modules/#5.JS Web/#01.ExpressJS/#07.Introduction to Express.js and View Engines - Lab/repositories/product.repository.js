const ProductSchema = require('../schemas/product');

let save = (product, callback) => {
    ProductSchema.create(product, (error, savedProduct) => {
        if (!error) {
            console.log(`Category [${savedProduct.name}] created!`);
        }

        callback(error, savedProduct);
    })
};

let findAll = (callback) => {
    let query = ProductSchema.find();
    query.exec(callback);
};

module.exports = {save,findAll};
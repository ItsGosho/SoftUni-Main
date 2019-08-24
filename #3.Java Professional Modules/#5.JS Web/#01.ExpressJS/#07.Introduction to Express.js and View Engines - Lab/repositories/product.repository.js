const ProductSchema = require('../schemas/product');

let save = (product, callback) => {
    ProductSchema.create(product, (error, savedProduct) => {
        if (!error) {
            console.log(`Category [${savedProduct.name}] created!`);
        }

        callback(error, savedProduct);
    })
};

let findAll = () => {
    let query = ProductSchema.find();
    return query.exec();
};

let findAllByCategoryId = (categoryId) => {
    let query = ProductSchema.find({'category': categoryId});
    return query.exec();
};

let findById = (id) => {
    return ProductSchema.findOne({'_id':id}).exec();
};

module.exports = {save, findAll, findAllByCategoryId,findById};
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
    return ProductSchema.findOne({'_id': id}).exec();
};

let removeById = (id) => {
    return ProductSchema.deleteOne({'_id': id}).exec();
};

let update = (id,product) => {
    return ProductSchema.updateOne({'_id': id},product).exec();
};

module.exports = {
    save,
    findAll,
    findAllByCategoryId,
    findById,
    removeById,
    update
};
const ProductModel = require('../domain/models/product.model');

let save = (product) => {
    return new ProductModel(product).save();
};

let findAll = () => {
    return ProductModel.find().exec();
};

let findAllByCategoryId = (categoryId) => {
    return ProductModel.find({'category': categoryId}).exec();
};

let findById = (id) => {
    return ProductModel.findOne({'_id': id}).exec();
};

let removeById = (id) => {
    return ProductModel.deleteOne({'_id': id}).exec();
};

let update = (id, product) => {
    return ProductModel.updateOne({'_id': id}, product).exec();
};

module.exports = {
    save,
    findAll,
    findAllByCategoryId,
    findById,
    removeById,
    update
};
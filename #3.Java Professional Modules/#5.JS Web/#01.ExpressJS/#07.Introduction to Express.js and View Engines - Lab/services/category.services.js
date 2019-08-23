const Repository = require('../repositories/category.repository');

let save = Repository.save;
let findAll = Repository.findAll;
let addProduct = (categoryId, productId) => {
    Repository.findById(categoryId, (error, category) => {
        category.products.push(productId);
        category.save();
    });
};

module.exports = {save, findAll,addProduct};
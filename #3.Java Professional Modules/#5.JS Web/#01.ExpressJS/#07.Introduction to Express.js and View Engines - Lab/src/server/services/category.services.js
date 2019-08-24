const CategoryRepository = require('../repositories/category.repository');

let save = CategoryRepository.save;
let findAll = CategoryRepository.findAll;
let addProduct = (categoryId, productId) => {
    CategoryRepository.findById(categoryId, (error, category) => {
        category.products.push(productId);
        category.save();
    });
};

let findById = (id) => {
    return CategoryRepository.findById(id);
};

let findByName = (name) => {
    return CategoryRepository.findByName(name);
};

module.exports = {save, findAll, addProduct,findById,findByName};
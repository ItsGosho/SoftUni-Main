const CategoryRepository = require('../repositories/category.repository');

let save = CategoryRepository.save;
let findAll = CategoryRepository.findAll;

let addProduct = async (categoryId, productId) => {
    let category = await CategoryRepository.findById(categoryId);
    category.products.push(productId);
    return category.save();
};

let findById = async (id) => {
    return CategoryRepository.findById(id);
};

let findByName = async (name) => {
    return CategoryRepository.findByName(name);
};

module.exports = {save, findAll, addProduct, findById, findByName};
const CategorySchema = require('../schemas/category.js');

let save = (category, callback) => {
    CategorySchema.create(category, (error, savedCategory) => {
        if (!error) {
            console.log(`Category [${savedCategory.name}] created!`);
        }
        callback(error, savedCategory);
    })
};
let findAll = (callback) => {
    let query = CategorySchema.find();
    query.exec(callback);
};

module.exports = {save,findAll};
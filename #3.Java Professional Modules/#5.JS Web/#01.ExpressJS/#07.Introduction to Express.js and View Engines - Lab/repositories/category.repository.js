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

let findById = (id) => {
    return CategorySchema.findOne({'_id':id}).exec();
};

let findByName = (name) => {
    return CategorySchema.findOne({'name':name}).exec();
};

module.exports = {save, findAll, findById,findByName};
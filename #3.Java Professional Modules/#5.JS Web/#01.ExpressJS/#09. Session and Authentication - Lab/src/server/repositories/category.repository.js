const CategorySchema = require('../domain/models/category.model');

let save = (category, callback) => {
    CategorySchema.create(category, (error, savedCategory) => {
        if (!error) {
            console.log(`Category [${savedCategory.name}] created!`);
        }
        callback(error, savedCategory);
    })
};

let findAll = () => {
    return CategorySchema.find().exec();
};

let findById = (id) => {
    return CategorySchema.findOne({'_id':id}).exec();
};

let findByName = (name) => {
    return CategorySchema.findOne({'name':name}).exec();
};

module.exports = {save, findAll, findById,findByName};
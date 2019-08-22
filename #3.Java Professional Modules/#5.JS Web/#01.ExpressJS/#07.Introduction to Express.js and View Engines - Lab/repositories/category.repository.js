const CategorySchema = require('../schemas/category');

let save = (category, callback) => {
    CategorySchema.create(category, (error, savedCategory) => {
        if (!error) {
            console.log('Category created!');
        }
        callback(error,savedCategory);
    })
};

module.exports = {save};
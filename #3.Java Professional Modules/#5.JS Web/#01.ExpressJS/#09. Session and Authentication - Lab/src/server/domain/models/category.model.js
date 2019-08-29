const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const Type = Schema.Types;

const categoryModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!'],
        unique: true
    },
    products: [{
        type: Type.ObjectID,
        ref: 'Product'
    }],
});

let CategoryModel = mongoose.model('Category', categoryModel);

module.exports = CategoryModel;
const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const Type = Schema.Types;

const productModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!']
    },
    description: {
        type: Type.String
    },
    price: {
        type: Type.Number,
        min: [0, `Price must be between 0 and ${Number.MAX_VALUE}`],
        max: [Number.MAX_VALUE, `Price must be between 0 and ${Number.MAX_VALUE}`],
        default: 0
    },
    image: {
        type: Type.String
    },
    category: {
        type: Type.ObjectId,
        ref: 'Category'
    },
    isBought: {
        type: Type.Boolean,
        default: false
    },
    creator: {
        type: Type.ObjectID,
        ref: 'User',
        required: [true,'Creator is not set!']
    }
});

let ProductModel = mongoose.model('Product', productModel);

module.exports = ProductModel;
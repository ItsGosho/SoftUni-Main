const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const categorySchema = new Schema({
    name: {
        type: Schema.Types.String,
        require: true
    },
    products: [{
        type: Schema.Types.ObjectID,
        ref: 'Product'
    }],
});

let Category = mongoose.model('Category', categorySchema);


module.exports = Category;
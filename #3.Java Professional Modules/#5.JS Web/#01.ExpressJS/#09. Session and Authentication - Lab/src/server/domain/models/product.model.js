const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.constants').Models;
const Schema = Mongoose.Schema;
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
        ref: ModelName.CATEGORY
    },
    isBought: {
        type: Type.Boolean,
        default: false
    },
    creator: {
        type: Type.ObjectID,
        ref: ModelName.USER,
        required: [true,'Creator is not set!']
    },
    buyer: {
        type: Type.ObjectID,
        ref: ModelName.USER
    }
});

productModel.post('save', function (product) {
    console.log(`-> `.red + `Product has been created/updated with name: ${product.name}`.cyan);
});

let ProductModel = Mongoose.model(ModelName.PRODUCT, productModel);

module.exports = ProductModel;
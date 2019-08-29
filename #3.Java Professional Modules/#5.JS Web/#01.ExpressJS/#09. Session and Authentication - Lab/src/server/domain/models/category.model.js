const Moongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.models.names');
const Schema = Moongoose.Schema;
const Type = Schema.Types;

const categoryModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!'],
        unique: true
    },
    products: [{
        type: Type.ObjectID,
        ref: ModelName.PRODUCT
    }],
    creator: {
        type: Type.ObjectID,
        ref: ModelName.USER,
        required: [true, 'Creator is not set!']
    }
});

categoryModel.pre('save', function (next) {
    console.log(`Category has been created with name: ${this.name}`);
    next();
});

let CategoryModel = Moongoose.model(ModelName.CATEGORY, categoryModel);

module.exports = CategoryModel;
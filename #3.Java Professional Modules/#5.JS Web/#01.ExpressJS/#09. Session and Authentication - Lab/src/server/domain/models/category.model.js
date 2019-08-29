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

categoryModel.post('save', function (category) {
    console.log(`-> `.red + `Category has been created/updated with name: ${category.name}`.cyan);
});

let CategoryModel = Moongoose.model(ModelName.CATEGORY, categoryModel);

module.exports = CategoryModel;
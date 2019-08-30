import Moongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';


const Schema = Moongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;

const categoryModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!'],
        unique: true
    },
    products: [{
        type: Type.ObjectID,
        ref: Models.PRODUCT
    }],
    creator: {
        type: Type.ObjectID,
        ref: Models.USER,
        required: [true, 'Creator is not set!']
    }
});

categoryModel.post('save', function (category) {
    console.log(`-> `.red + `Category has been created/updated with name: ${category.name}`.cyan);
});

let CategoryModel = Moongoose.model(Models.CATEGORY, categoryModel);

export default CategoryModel;
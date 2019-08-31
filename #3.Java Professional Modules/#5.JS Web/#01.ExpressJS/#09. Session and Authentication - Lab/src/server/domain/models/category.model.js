import Moongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from 'sprintf-js';


const Schema = Moongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;
const LogModel = LoggingConstants.MONGOOSE.MODEL.CATEGORY;
const ParseString = Format.sprintf;

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
    console.log(ParseString(LogModel.SAVE,category.name));
});

let CategoryModel = Moongoose.model(Models.CATEGORY, categoryModel);

export default CategoryModel;
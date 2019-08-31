import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;
const LogModel = LoggingConstants.MONGOOSE.MODEL.USER;
const ParseString = Format.sprintf;

const userModel = new Schema({
    username: {
        type: Type.String,
        required: [true, 'Username is required!'],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        trim: true
    },
    firstName: {
        type: Type.String,
        trim: true
    },
    lastName: {
        type: Type.String,
        trim: true
    },
    age: {
        type: Type.Number,
        min: [0, 'Age must be between 0 and 130'],
        max: [130, 'Age must be between 0 and 130']
    },
    gender: {
        type: Type.String,
        enum: {
            values: ['Male', 'Female']
        },
        message: 'Gender should be Male or Female!'
    },
    boughtProducts: [
        {
            type: Type.ObjectID,
            ref: Models.PRODUCT
        }
    ],
    createdProducts: [
        {
            type: Type.ObjectID,
            ref: Models.PRODUCT
        }
    ],
    createdCategories: [
        {
            type: Type.ObjectID,
            ref: Models.CATEGORY
        }
    ]
});

userModel.post('save', function (user) {
    console.log(ParseString(LogModel.SAVE, user.username));
});


let UserModel = Mongoose.model(Models.USER, userModel);

export default UserModel;
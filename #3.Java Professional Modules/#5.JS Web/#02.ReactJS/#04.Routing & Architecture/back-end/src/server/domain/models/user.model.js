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
    email: {
        type: Type.String,
        required: [true, 'Email is required!'],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        trim: true
    },
});

userModel.post('save', function (user) {
    console.log(ParseString(LogModel.SAVE, user.username));
});


let UserModel = Mongoose.model(Models.USER, userModel);

export default UserModel;
import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const Models = MongooseConstants.MODELS;
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
        required: [true, 'Password is required!'],
        trim: true
    },
    roles: [{
        type: Type.String
    }],
    enrolledCourses: [{
        type: Type.ObjectID,
        ref: Models.COURSE
    }]
});

userModel.post('save', function (user) {
    console.log(ParseString(LogModel.SAVE, user.username));
});


let UserModel = Mongoose.model(Models.USER, userModel);

export default UserModel;
import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {UserModelValidationMessages} from "../../constants/mongo/mongo.validation.constants";
import {UserModelLogging} from "../../constants/mongo/mongo.logging.constants";
import ModelNames from "../../constants/mongo/mongo.models.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    username: {
        type: Type.String,
        required: [true, UserModelValidationMessages.USERNAME_REQUIRED],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        required: [true,UserModelValidationMessages.PASSWORD_REQUIRED],
        trim: true
    },
    firstName: {
        type: Type.String,
        required: [true,UserModelValidationMessages.FIRST_NAME_REQUIRED],
        trim: true
    },
    lastName: {
        type: Type.String,
        required: [true,UserModelValidationMessages.LAST_NAME_REQUIRED],
        trim: true
    },
    /*TODO: collection of teams*/
    profilePicture: {
        type: Type.String,
        trim: true,
        default: 'https://www.w3schools.com/howto/img_avatar.png'
    },
    roles: [
        {
            type: Type.String,
        }
    ]
});

model.post('save', function (user) {
    console.log(ParseString(UserModelLogging.SAVE, user.username));
});


let UserModel = Mongoose.model(ModelNames.USER, model);

export default UserModel;
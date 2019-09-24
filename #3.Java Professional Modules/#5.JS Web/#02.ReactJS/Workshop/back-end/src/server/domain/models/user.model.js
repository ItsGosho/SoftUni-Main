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
    email: {
        type: Type.String,
        required: [true, UserModelValidationMessages.EMAIL_REQUIRED],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        trim: true
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
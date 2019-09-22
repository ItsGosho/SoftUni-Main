import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {UserValidationConstants} from "../../constants/mongo/mongo.validation.constants";
import {UserLoggingConstants} from "../../constants/mongo/mongo.logging.constants";
import {ModelNameConstants} from "../../constants/mongo/mongo.models.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    username: {
        type: Type.String,
        required: [true, UserValidationConstants.USERNAME_REQUIRED],
        unique: true,
        trim: true,
    },
    email: {
        type: Type.String,
        required: [true, UserValidationConstants.EMAIL_REQUIRED],
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
    console.log(ParseString(UserLoggingConstants.SAVE, user.username));
});


let UserModel = Mongoose.model(ModelNameConstants.USER, model);

export default UserModel;
import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {MongoModelValidationMessageConstants} from "../../constants/mongo/mongo.validation.constants";
import {MongoModelLoggingMessageConstants} from "../../constants/mongo/mongo.logging.constants";
import {MongoModelsNamesConstants} from "../../constants/mongo/mongo.constants";

const ValidationMessages = MongoModelValidationMessageConstants.USER;
const LoggingMessages = MongoModelLoggingMessageConstants.USER;


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const userModel = new Schema({
    username: {
        type: Type.String,
        required: [true, ValidationMessages.USERNAME_REQUIRED],
        unique: true,
        trim: true,
    },
    email: {
        type: Type.String,
        required: [true, ValidationMessages.EMAIL_REQUIRED],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        trim: true
    },
});

userModel.post('save', function (user) {
    console.log(ParseString(LoggingMessages.SAVE, user.username));
});


let UserModel = Mongoose.model(MongoModelsNamesConstants.USER, userModel);

export default UserModel;
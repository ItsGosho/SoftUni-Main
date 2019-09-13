import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {MongoModelValidationMessageConstants} from "../../constants/mongo/mongo.validation.constants";
import {MongoModelLoggingMessageConstants} from "../../constants/mongo/mongo.logging.constants";
import {MongoModelsNamesConstants} from "../../constants/mongo/mongo.constants";

const ValidationMessages = MongoModelValidationMessageConstants.TOKEN;
const LoggingMessages = MongoModelLoggingMessageConstants.TOKEN;


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const jwtTokenModel = new Schema({
    token: {
        type: Type.String,
        required: [true, ValidationMessages.TOKEN_REQUIRED]
    },
    user: {
        type: Type.ObjectID,
        ref: MongoModelsNamesConstants.USER
    }
});

jwtTokenModel.post('save', function (token) {
    console.log(ParseString(LoggingMessages.SAVE, token.user));
});

jwtTokenModel.post('deleteMany', function (token) {
    console.log(ParseString(LoggingMessages.DELETE_MANY, token.deletedCount));
});

let JWTTokenModel = Mongoose.model(MongoModelsNamesConstants.JWT, jwtTokenModel);

export default JWTTokenModel;
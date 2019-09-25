import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {TokenModelValidationMessages} from "../../constants/mongo/mongo.validation.constants";
import ModelNames from "../../constants/mongo/mongo.models.constants";
import {TokenModelLogging} from "../../constants/mongo/mongo.logging.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    token: {
        type: Type.String,
        required: [true, TokenModelValidationMessages.TOKEN_REQUIRED]
    },
    user: {
        type: Type.ObjectId,
        ref: ModelNames.USER
    }
});

model.post('save', function (token) {
    console.log(ParseString(TokenModelLogging.SAVE, token.user));
});

model.post('deleteMany', function (token) {
    console.log(ParseString(TokenModelLogging.DELETE_MANY, token.deletedCount));
});

let TokenModel = Mongoose.model(ModelNames.JWT, model);

export default TokenModel;
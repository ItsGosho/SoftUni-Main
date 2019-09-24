import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {TokenValidationConstants} from "../../constants/mongo/mongo.validation.constants";
import {ModelNameConstants} from "../../constants/mongo/mongo.models.constants";
import {TokenLoggingConstants} from "../../constants/mongo/mongo.logging.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    token: {
        type: Type.String,
        required: [true, TokenValidationConstants.TOKEN_REQUIRED]
    },
    user: {
        type: Type.ObjectId,
        ref: ModelNameConstants.USER
    }
});

model.post('save', function (token) {
    console.log(ParseString(TokenLoggingConstants.SAVE, token.user));
});

model.post('deleteMany', function (token) {
    console.log(ParseString(TokenLoggingConstants.DELETE_MANY, token.deletedCount));
});

let JWTTokenModel = Mongoose.model(ModelNameConstants.JWT, model);

export default JWTTokenModel;
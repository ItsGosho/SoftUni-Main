import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const Models = MongooseConstants.MODELS;
const LogModel = LoggingConstants.MONGOOSE.MODEL.JWT_TOKEN;
const ParseString = Format.sprintf;

const jwtTokenModel = new Schema({
    token: {
        type: Type.String,
        required: [true, 'Token is not present!']
    },
    user: {
        type: Type.ObjectID,
        ref: Models.USER
    }
});

jwtTokenModel.post('save', function (token) {
    console.log(ParseString(LogModel.SAVE,token.user));
});

jwtTokenModel.post('deleteMany', function (token) {
    console.log(ParseString(LogModel.DELETE_MANY,token.deletedCount));
});

let JWTTokenModel = Mongoose.model(Models.JWT, jwtTokenModel);

export default JWTTokenModel;
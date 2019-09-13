import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {MongoModelValidationMessageConstants} from "../../constants/mongo/mongo.validation.constants";
import {MongoModelLoggingMessageConstants} from "../../constants/mongo/mongo.logging.constants";
import {MongoModelsNamesConstants} from "../../constants/mongo/mongo.constants";

const ValidationMessages = MongoModelValidationMessageConstants.ROLE;
const LoggingMessages = MongoModelLoggingMessageConstants.ROLE;

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const roleModel = new Schema({
    name: {
        type: Type.String,
        required: [true, ValidationMessages.NAME_REQUIRED]
    },
    users: [
        {
            type: Type.ObjectID,
            ref: MongoModelsNamesConstants.USER
        }
    ]
});

roleModel.post('save', function (role) {
    console.log(ParseString(LoggingMessages.SAVE,role.name));
});

let RoleModel = Mongoose.model(MongoModelsNamesConstants.ROLE, roleModel);

export default RoleModel;
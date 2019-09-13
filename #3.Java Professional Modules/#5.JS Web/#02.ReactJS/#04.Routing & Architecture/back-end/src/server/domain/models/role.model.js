import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {RoleValidationConstants} from "../../constants/mongo/mongo.validation.constants";
import {ModelNameConstants} from "../../constants/mongo/mongo.models.constants";
import {RoleLoggingConstants} from "../../constants/mongo/mongo.logging.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const roleModel = new Schema({
    name: {
        type: Type.String,
        required: [true, RoleValidationConstants.NAME_REQUIRED]
    },
    users: [
        {
            type: Type.ObjectID,
            ref: ModelNameConstants.USER
        }
    ]
});

roleModel.post('save', function (role) {
    console.log(ParseString(RoleLoggingConstants.SAVE, role.name));
});

let RoleModel = Mongoose.model(ModelNameConstants.ROLE, roleModel);

export default RoleModel;
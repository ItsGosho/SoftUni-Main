import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;
const LogModel = LoggingConstants.MONGOOSE.MODEL.ROLE;
const ParseString = Format.sprintf;

const roleModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!']
    },
    users: [
        {
            type: Type.ObjectID,
            ref: Models.USER
        }
    ]
});

roleModel.post('save', function (role) {
    console.log(ParseString(LogModel.SAVE,role.name));
});

let RoleModel = Mongoose.model(Models.ROLE, roleModel);

export default RoleModel;
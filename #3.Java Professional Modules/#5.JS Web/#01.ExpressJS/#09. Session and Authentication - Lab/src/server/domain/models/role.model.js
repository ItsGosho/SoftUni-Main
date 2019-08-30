import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;


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
    console.log(`-> `.red + `Role has been create/updated with name: ${role.name}`.cyan);
});

let RoleModel = Mongoose.model(Models.ROLE, roleModel);

export default RoleModel;
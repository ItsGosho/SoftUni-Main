const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.models.names');
const Schema = Mongoose.Schema;
const Type = Schema.Types;

const roleModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!']
    },
    users: [
        {
            type: Type.ObjectID,
            ref: ModelName.USER
        }
    ]
});

let RoleModel = Mongoose.model(ModelName.ROLE, roleModel);

module.exports = RoleModel;
const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.constants').Models;
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

roleModel.post('save', function (role) {
    console.log(`-> `.red + `Role has been create/updated with name: ${role.name}`.cyan);
});

let RoleModel = Mongoose.model(ModelName.ROLE, roleModel);

module.exports = RoleModel;
const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const Type = Schema.Types;

const roleModel = new Schema({
    name: {
        type: Type.String,
        required: [true, 'Name is required!']
    },
    users: [
        {
            type: Type.ObjectID,
            ref: 'User'
        }
    ]
});

let RoleModel = mongoose.model('Product', roleModel);

module.exports = RoleModel;
const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.models.names');
const Schema = Mongoose.Schema;
const Type = Schema.Types;

const userModel = new Schema({
    username: {
        type: Type.String,
        required: [true, 'Username is required!'],
        unique: true,
        trim: true,
    },
    password: {
        type: Type.String,
        trim: true
    },
    firstName: {
        type: Type.String,
        trim: true
    },
    lastName: {
        type: Type.String,
        trim: true
    },
    age: {
        type: Type.Number,
        min: [0, 'Age must be between 0 and 130'],
        max: [130, 'Age must be between 0 and 130']
    },
    gender: {
        type: Type.String,
        enum: {
            values: ['Male', 'Female']
        },
        message: 'Gender should be Male or Female!'
    },
    role: {
        type: Type.ObjectID,
        ref: ModelName.ROLE,
        required: [true, 'Role is not present!']
    },
    boughtProducts: [
        {
            type: Type.ObjectID,
            ref: ModelName.PRODUCT
        }
    ],
    createdProducts: [
        {
            type: Type.ObjectID,
            ref: ModelName.PRODUCT
        }
    ],
    createdCategories: [
        {
            type: Type.ObjectID,
            ref: ModelName.CATEGORY
        }
    ]
});

userModel.post('save', function (user) {
    console.log(`-> `.red + `User has been created/update with username: ${user.username}`.cyan);
});

let UserModel = Mongoose.model(ModelName.USER, userModel);

module.exports = UserModel;
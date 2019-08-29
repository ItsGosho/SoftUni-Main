const mongoose = require('mongoose');
const Schema = mongoose.Schema;
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
    jwtToken: {
        type: Type.ObjectID,
        ref: 'JWT'
    },
    role: {
        type: Type.ObjectID,
        ref: 'Role',
        required: [true, 'Role is not present!']
    },
    boughtProducts: [
        {
            type: Type.ObjectID,
            ref: 'Product'
        }
    ],
    createdProducts: [
        {
            type: Type.ObjectID,
            ref: 'Product'
        }
    ],
    createdCategories: [
        {
            type: Type.ObjectID,
            ref: 'Category'
        }
    ]
});

let UserModel = mongoose.model('User', userModel);

module.exports = UserModel;
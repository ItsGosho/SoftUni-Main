const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.constants').Models;
const Schema = Mongoose.Schema;
const Type = Schema.Types;

const jwtTokenModel = new Schema({
    token: {
        type: Type.String,
        required: [true, 'Token is not present!']
    },
    user: {
        type: Type.ObjectID,
        ref: ModelName.USER
    }
});

jwtTokenModel.post('save', function (token) {
    console.log(`-> `.red + `Token has been created/updated for user with id: ${token.user}`.cyan);
});

jwtTokenModel.post('deleteMany', function (token) {
    console.log(`-> `.red + `${token.deletedCount} tokens have been deleted!`.cyan);
});

let JWTTokenModel = Mongoose.model(ModelName.JWT, jwtTokenModel);

module.exports = JWTTokenModel;
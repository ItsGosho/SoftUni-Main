const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const Type = Schema.Types;

const jwtTokenModel = new Schema({

});

let JWTTokenModel = mongoose.model('JWT', jwtTokenModel);

module.exports = JWTTokenModel;
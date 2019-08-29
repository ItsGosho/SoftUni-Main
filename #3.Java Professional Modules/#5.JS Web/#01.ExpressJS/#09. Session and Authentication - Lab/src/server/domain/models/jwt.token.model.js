const Mongoose = require('mongoose');
const ModelName = require('../../constants/mongoose.models.names');
const Schema = Mongoose.Schema;
const Type = Schema.Types;

const jwtTokenModel = new Schema({

});

let JWTTokenModel = Mongoose.model(ModelName.JWT, jwtTokenModel);

module.exports = JWTTokenModel;
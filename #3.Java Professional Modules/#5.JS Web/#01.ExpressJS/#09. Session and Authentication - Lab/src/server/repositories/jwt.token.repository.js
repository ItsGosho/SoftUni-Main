const TokenModel = require('../domain/models/jwt.token.model');

let save = (token) => {
    return new TokenModel(token).save();
};

let findById = (id) => {
    return TokenModel.findById(id).exec();
};

let findByToken = (token) => {
    return TokenModel.findOne({token}).exec();
};

let findByUserId = (userId) => {
    return TokenModel.findOne({user: userId}).exec();
};

let deleteByUserId = (userId) => {
    return TokenModel.deleteOne({user: userId}).exec();
};

let deleteAllByUserId = (userId) => {
    return TokenModel.deleteMany({user: userId}).exec();
};

let deleteByToken = (token) => {
    return TokenModel.deleteOne({token}).exec();
};

module.exports = {
    save,
    findById,
    findByToken,
    findByUserId,
    deleteByUserId,
    deleteByToken,
    deleteAllByUserId
};
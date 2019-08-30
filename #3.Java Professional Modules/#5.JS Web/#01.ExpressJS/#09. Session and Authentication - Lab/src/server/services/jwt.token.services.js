const JWTRepository = require('../repositories/jwt.token.repository');
const JWT = require('jsonwebtoken');
const FileSystem = require('fs');
const JWTPaths = require('../constants/resource.paths.constants').JWT;

let save = async (token) => {
    return await JWTRepository.save(token);
};

let generateToken = (data) => {
    const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');
    return JWT.sign(data, secretKey, {expiresIn: '24h'});
};

let isValid = (token) => {
    const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');

    try {
        JWT.verify(token, secretKey);
        return true;
    } catch (e) {
        return false;
    }
};

let decode = (token) => {
    const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');

    return JWT.decode(token, secretKey);
};

let removeAllByUserId = async (userId) => {
    return JWTRepository.deleteAllByUserId(userId);
};

module.exports = {
    save,
    generateToken,
    isValid,
    decode,
    removeAllByUserId
};
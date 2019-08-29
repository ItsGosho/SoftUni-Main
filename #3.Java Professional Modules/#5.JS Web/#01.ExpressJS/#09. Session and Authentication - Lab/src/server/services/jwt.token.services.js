const JWT = require('jsonwebtoken');
const FileSystem = require('fs');
const FilePaths = require('../constants/file.path.constants');

let generateToken = (data) => {
    const secretKey = FileSystem.readFileSync(FilePaths.JWT_SECRET, 'utf8');
    return JWT.sign(data, secretKey, {expiresIn: '24h'});
};

let isValid = (token) => {
    const secretKey = FileSystem.readFileSync(FilePaths.JWT_SECRET, 'utf8');

    try {
        JWT.verify(token, secretKey);
        return true;
    } catch (e) {
        return false;
    }
};

let decode = (token) => {
    const secretKey = FileSystem.readFileSync(FilePaths.JWT_SECRET, 'utf8');

   return JWT.decode(token,secretKey);
};

module.exports = {
    generateToken,
    isValid,
    decode
};
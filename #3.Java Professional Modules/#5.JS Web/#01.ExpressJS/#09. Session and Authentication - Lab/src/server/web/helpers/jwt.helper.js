let JWTServices = require('../../services/jwt.token.services');
let UserServices = require('../../services/user.services');

let getCurrentUser = async (request) => {

    if (request.cookies.jwt === undefined) {
        return null;
    }

    let tokeData = JWTServices.decode(request.cookies.jwt);
    return await UserServices.findByUsername(tokeData.username);
};

module.exports = {getCurrentUser};
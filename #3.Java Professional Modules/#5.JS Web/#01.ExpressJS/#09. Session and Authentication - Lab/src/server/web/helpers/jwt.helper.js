let JWTServices = require('../../services/jwt.token.services');
let UserServices = require('../../services/user.services');

let getCurrentUser = async (request) => {

    if (request.cookies.jwt === undefined) {
        return null;
    }

    let tokeData = JWTServices.decode(request.cookies.jwt);
    return await UserServices.findByUsername(tokeData.username);
};

let attachToken = (token,response) => {
    response.cookie('jwt', token, {maxAge: 86_400_000, httpOnly: true});
};

module.exports = {
    getCurrentUser,
    attachToken
};
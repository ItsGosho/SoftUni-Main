let JWTServices = require('../../services/jwt.token.services');

module.exports = (request, response, next) => {
    let token = request.cookies.jwt;

    if (token !== undefined && JWTServices.isValid(token)) {
        next();
        return;
    }

    response.send('<center><h1 style="color:red">Invalid JWT Token!</h1></center>')
};


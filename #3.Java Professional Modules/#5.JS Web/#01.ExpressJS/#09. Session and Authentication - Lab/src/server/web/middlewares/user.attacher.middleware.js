let JWTHelper = require('../helpers/jwt.helper');

module.exports = async (request, response, next) => {
    request.user = await JWTHelper.getCurrentUser(request);
    next();
};

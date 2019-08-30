/*Note that before this middleware is executed a user must be attached to the request somehow*/

let RoleServices = require('../../services/role.services');

module.exports = (requiredRole) => {
    return async (request, response, next) => {
        let user = request.user;
        let role = await RoleServices.findRoleByUserId(user.id);

        if (role.name.toLowerCase() === requiredRole.toLowerCase()) {
            next();
            return;
        }

        response.send(`<center><h1 style="color:red">You need to be <span style="color:green">${role.name}</span> to access this route!</h1></center>`);
    }
};


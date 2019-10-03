import RoutingUrls from '../../constants/routing.urls';
import RoleHelper from '../helpers/role.helper'

/*Note that before this middleware is executed a user must be attached to the request somehow*/

export default (requiredRole) => {
    return async (request, response, next) => {
        let user = request.user;
        let role = RoleHelper.getRole(user);

        if (role === requiredRole) {
            next();
            return;
        }

        response.send(`<center><h1 style="color:red">You need to be <span style="color:green">${requiredRole}</span> to access this route!</h1></center>`);
    }
};


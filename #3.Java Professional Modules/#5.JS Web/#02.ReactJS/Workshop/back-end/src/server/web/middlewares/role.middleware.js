import RestResponseHelper from "../helpers/rest.response.helper";
import JWTServices from "../../services/jwt.token.services";
import RoleHelper from "../../helpers/role.helper";

/*Note that before this middleware is executed a user must be attached to the request somehow*/

const RoleMiddleware = (requiredRole) => {
    return async (request, response, next) => {
        let user = request.user;
        let role = RoleHelper.getHighestRoleFrom(user.roles);

        if (role.toLowerCase() === requiredRole.toLowerCase()) {
            next();
            return;
        }

        RestResponseHelper.respondErrorMessage(response, `You must be ${requiredRole} to access this route!`)
    }
};

export default RoleMiddleware;


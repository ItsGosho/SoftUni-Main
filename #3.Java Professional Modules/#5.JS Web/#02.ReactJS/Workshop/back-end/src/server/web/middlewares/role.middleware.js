import RestResponseHelper from "../helpers/rest.response.helper";
import JWTServices from "../../services/jwt.token.services";

/*Note that before this middleware is executed a user must be attached to the request somehow*/

const RoleMiddleware = (requiredRole) => {
    return async (request, response, next) => {
        /* let user = request.user;
         let role = await RoleServices.findRoleByUserId(user.id);

         if (role.name.toLowerCase() === requiredRole.toLowerCase()) {
             next();
             return;
         }
 */
        RestResponseHelper.respondErrorMessage(response, `You must be ${requiredRole} to access this route!`)
    }
};

export default RoleMiddleware;


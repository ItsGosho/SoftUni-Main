import JWTServices from '../../services/jwt.token.services';
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";

//Check if user is logged in ,by jwt token if its valid
const LoggedInMiddleware = async (request, response, next) => {
    let token = request.cookies.jwt;

    if (token !== undefined && await JWTServices.isValid(token)) {
        next();
        return;
    }

    RestResponseHelper.respondErrorMessage(response, RestResponseMessages.NOT_LOGGED_IN)
};

export default LoggedInMiddleware;

import JWTServices from '../../services/jwt.token.services';
import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";

const LoggedInMiddleware = async (request, response, next) => {
    let token = request.cookies.jwt;

    console.log(request.cookies);
    if (token !== undefined && await JWTServices.isValid(token)) {
        next();
        return;
    }

    RestResponseHelper.respondErrorMessage(response, RestResponseMessages.NOT_LOGGED_IN)
};

export default LoggedInMiddleware;

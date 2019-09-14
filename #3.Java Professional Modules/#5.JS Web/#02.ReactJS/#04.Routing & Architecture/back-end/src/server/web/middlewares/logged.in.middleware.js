import JWTServices from '../../services/jwt.token.services';
import RestResponseHelper from "../helpers/rest.response.helper";

const LoggedInMiddleware = async (request, response, next) => {
    let token = request.cookies.jwt;

    if (token !== undefined && await JWTServices.isValid(token)) {
        next();
        return;
    }

    RestResponseHelper.respondError(response, 'You are not logged in!')
};

export default LoggedInMiddleware;

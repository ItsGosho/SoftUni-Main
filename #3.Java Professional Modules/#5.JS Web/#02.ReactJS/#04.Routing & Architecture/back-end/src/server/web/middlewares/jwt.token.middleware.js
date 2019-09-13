import JWTServices from '../../services/jwt.token.services';
import {UserRoutingURLs} from "../../constants/web/routing.urls";


export default async (request, response, next) => {
    let token = request.cookies.jwt;

    if (token !== undefined && await JWTServices.isValid(token)) {
        next();
        return;
    }

    response.redirect(UserRoutingURLs.LOGIN);
};


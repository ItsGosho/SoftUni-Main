import RestResponseHelper from "../helpers/rest.response.helper";
import RestResponseMessages from "../../constants/web/rest.message.constants";

const LoggedOutMiddleware = (request, response, next) => {
    let token = request.cookies.jwt;

    if (token === undefined) {
        next();
        return;
    }

    RestResponseHelper.respondErrorMessage(response,RestResponseMessages.LOGGED_OUT)
};

export default LoggedOutMiddleware;


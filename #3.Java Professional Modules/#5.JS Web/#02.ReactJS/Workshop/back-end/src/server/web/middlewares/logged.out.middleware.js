import RestResponseHelper from "../helpers/rest.response.helper";

const LoggedOutMiddleware = (request, response, next) => {
    let token = request.cookies.jwt;

    if (token === undefined) {
        next();
        return;
    }

    RestResponseHelper.respondErrorMessage(response,'You must be logged out!')
};

export default LoggedOutMiddleware;


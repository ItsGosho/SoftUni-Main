import NotificationHelper from '../../helpers/notification.helper'
import { RoutingURLs } from '../../constants/web/routing.urls.constants'

const LoggedOutMiddleware = (request, response, next) => {
    let token = request.cookies.jwt;

    if (token === undefined) {
        next();
        return;
    }

    NotificationHelper.prepareError(request, 'Please logout to access this route!')
    response.redirect(RoutingURLs.HOME)
};

export default LoggedOutMiddleware;


import JWTHelper from '../helpers/jwt.helper';
import RoutingUrls from '../../constants/routing.urls';


export default async (request, response, next) => {
    request.user = await JWTHelper.getCurrentUser(request);
    next();
};

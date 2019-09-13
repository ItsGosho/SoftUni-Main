import JWTHelper from '../helpers/jwt.helper';


export default async (request, response, next) => {
    request.user = await JWTHelper.getCurrentUser(request);
    next();
};

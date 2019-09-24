import JWTHelper from '../helpers/jwt.helper';

//Attaches user to the request by JWT token
const UserAttacherMiddleware = async (request, response, next) => {
    request.user = await JWTHelper.getCurrentUser(request);
    next();
};


export default UserAttacherMiddleware;

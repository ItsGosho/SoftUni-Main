import JWTHelper from '../helpers/jwt.helper';

const UserAttacherMiddleware = async (request, response, next) => {
    request.user = await JWTHelper.getCurrentUser(request);
    next();
};

export default UserAttacherMiddleware;

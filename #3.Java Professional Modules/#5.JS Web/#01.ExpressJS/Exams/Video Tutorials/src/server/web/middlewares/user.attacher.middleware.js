import JWTHelper from '../helpers/jwt.helper';
import UserRoles from '../../domain/models/enums/role.enums';
import RoutingUrls from '../../constants/routing.urls';
import RoleHelper from '../helpers/role.helper'

export default async (request, response, next) => {
    let user = await JWTHelper.getCurrentUser(request);
    if(user !== null){
        user.role = RoleHelper.getRole(user);
        request.user = user;
    }
    next();
};


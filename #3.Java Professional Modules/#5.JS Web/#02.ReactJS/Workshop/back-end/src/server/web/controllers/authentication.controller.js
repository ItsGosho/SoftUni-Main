import Express from 'express';
import {UserRoutingURLs} from "../../constants/web/routing.urls";
import RestResponseHelper from "../helpers/rest.response.helper";
import UserServices from "../../services/user.services";
import JWTHelper from "../helpers/jwt.helper";
import JWTServices from "../../services/jwt.token.services";
import RoleHelper from "../../helpers/role.helper";


const Router = Express.Router();

Router.post(UserRoutingURLs.LOGIN, async (request, response) => {

    let {username, password} = request.body;

    let token = await UserServices.proceedToken(username);

    await JWTHelper.attachToken(token.token, response);

    let {id, roles} = await UserServices.findByUsername(username);

    let data = {
        username: username,
        role: RoleHelper.getHighestRoleFrom(roles)
    };

    RestResponseHelper.respondSuccessful(response, 'Login successful!', data);
});

Router.post(UserRoutingURLs.REGISTER, async (request, response) => {
    let {username, password, email} = request.body;

    let user = {
        username,
        password,
        email
    };

    await UserServices.register(user);

    RestResponseHelper.respondSuccessful(response, 'Registration successful!', null);
});

Router.post(UserRoutingURLs.LOGOUT, async (request, response) => {
    let user = await JWTHelper.getCurrentUser(request);

    if (user !== null) {

        await JWTServices.removeAllByUserId(user.id);
        response.clearCookie('jwt');
        return RestResponseHelper.respondSuccessful(response, 'Logout successful!', {});
    }
});


export default Router;
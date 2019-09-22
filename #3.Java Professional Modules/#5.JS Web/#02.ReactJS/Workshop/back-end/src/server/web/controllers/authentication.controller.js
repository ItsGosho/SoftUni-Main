import Express from 'express';
import UserServices from '../../services/user.services';
import JWTHelper from '../helpers/jwt.helper';
import {UserRoutingURLs} from "../../constants/web/routing.urls";
import RestResponseHelper from "../helpers/rest.response.helper";
import RoleServices from "../../services/role.services";
import JWTServices from "../../services/jwt.token.services";


const Router = Express.Router();

Router.post(UserRoutingURLs.LOGIN, async (request, response) => {
    let {username, password} = request.body;

    if (await UserServices.isCredentialsValid(username, password)) {
        let token = await UserServices.proceedToken(username);

        await JWTHelper.attachToken(token.token, response);

        let {id} = await UserServices.findByUsername(username);
        let {name} = await RoleServices.findRoleByUserId(id);
        let data = {
            username: username,
            role: name
        };

        RestResponseHelper.respondSuccessful(response, 'Login successful!', data);
        return;
    }

    RestResponseHelper.respondErrorMessage(response, 'Credentials are invalid!');
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
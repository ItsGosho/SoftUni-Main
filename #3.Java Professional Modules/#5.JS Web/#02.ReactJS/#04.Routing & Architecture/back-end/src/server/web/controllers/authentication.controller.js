import Express from 'express';
import UserServices from '../../services/user.services';
import JWTServices from '../../services/jwt.token.services';
import JWTHelper from '../helpers/jwt.helper';
import {UserRoutingURLs} from "../../constants/web/routing.urls";


const Router = Express.Router();

Router.post(UserRoutingURLs.LOGIN, async (request, response) => {
    let {username, password} = request.body;

    if (await UserServices.isCredentialsValid(username, password)) {
        let token = await UserServices.proceedToken(username);

        await JWTHelper.attachToken(token.token, response);
        /*SUCCESSFUL*/
        return;
    }

    /*FAILED*/
});

Router.post(UserRoutingURLs.REGISTER, async (request, response) => {
    let {username, password, confirmedPassword, firstName, lastName, age, gender} = request.body;

    if (password !== confirmedPassword) {
        /*FAILED*/
        return;
    }

    let user = {
        username,
        password,
        firstName,
        lastName,
        age,
        gender
    };

    await UserServices.register(user);
    /*SUCCESSFUL*/
});

Router.post(UserRoutingURLs.LOGOUT, async (request, response) => {
    let user = await JWTHelper.getCurrentUser(request);

    if (user !== null) {

        await JWTServices.removeAllByUserId(user.id);
        response.clearCookie('jwt');
        /*SUCCESSFUL*/
        return;
    }

    /*FAILED*/
});


export default Router;
import Express from 'express';
import UserServices from '../../services/user.services';
import JWTHelper from '../helpers/jwt.helper';
import {MovieRoutingURLs, UserRoutingURLs} from "../../constants/web/routing.urls";
import RestResponseHelper from "../helpers/rest.response.helper";
import RoleServices from "../../services/role.services";


const Router = Express.Router();

Router.post(MovieRoutingURLs.CREATE, async (request, response) => {
    RestResponseHelper.respondSuccessful(response,'Successful accesing movies create!',null);
});

Router.get(MovieRoutingURLs.ALL, async (request, response) => {
    RestResponseHelper.respondSuccessful(response,'Successful accesing movies all!',null);
});

export default Router;
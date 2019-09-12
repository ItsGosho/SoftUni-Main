import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import UserServices from '../../services/user.services';
import JWTServices from '../../services/jwt.token.services';
import ViewPaths from '../../constants/resource.paths.constants';
import JWTHelper from '../helpers/jwt.helper';


const Router = Express.Router();

Router.get('/test', async (request, response) => {
    response.send('<h1>test</h1>');
});


export default Router;
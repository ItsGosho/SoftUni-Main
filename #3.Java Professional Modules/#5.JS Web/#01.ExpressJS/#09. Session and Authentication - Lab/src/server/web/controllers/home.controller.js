import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import ProductServices from '../../services/product.services';
import ViewPaths from '../../constants/resource.paths.constants';
import Role from '../middlewares/role.middleware';
import JWTHelper from '../helpers/jwt.helper';


const Router = Express.Router();


Router.get(RoutingURLs.BASE.HOME, async (request, response) => {
    let products = await ProductServices.findAll();

    response.render(ViewPaths.OTHER.HOME, {user: request.user, products});
});

export default Router;
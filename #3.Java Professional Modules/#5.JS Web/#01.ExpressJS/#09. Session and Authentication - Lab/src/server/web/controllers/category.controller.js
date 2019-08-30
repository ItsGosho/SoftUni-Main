import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import CategoryServices from '../../services/category.services';
import ViewPaths from '../../constants/resource.paths.constants';


const Router = Express.Router();


Router.get(RoutingURLs.CATEGORY.CREATE, (request, response) => {
    response.render(ViewPaths.CATEGORY.CREATE_CATEGORY, {user: request.user});
});

Router.post(RoutingURLs.CATEGORY.CREATE, async (request, response) => {
    let category = {
        name: request.body.name
    };

    await CategoryServices.save(category);
    response.redirect(RoutingURLs.HOME);
});

export default Router;
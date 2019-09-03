import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import ViewPaths from '../../constants/resource.paths.constants';
import Role from '../middlewares/role.middleware';
import JWTHelper from '../helpers/jwt.helper';
import CourseServices from "../../services/course.services";


const Router = Express.Router();


Router.get(RoutingURLs.BASE.HOME, async (request, response) => {

    let courses = await CourseServices.findAll();

    response.render(ViewPaths.OTHER.HOME, {user: request.user,courses});
});

export default Router;
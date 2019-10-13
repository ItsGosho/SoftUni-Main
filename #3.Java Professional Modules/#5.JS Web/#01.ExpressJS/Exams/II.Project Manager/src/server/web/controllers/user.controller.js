import Express from 'express'
import {TeamRoutingURLs, UserRoutingURLs} from '../../constants/web/routing.urls.constants'
import {ViewsResourcePaths} from '../../constants/path/resource.paths.constants'
import TeamServices from "../../services/team.services";
import JWTHelper from "../helpers/jwt.helper";
import ProjectServices from "../../services/project.services";

const Router = Express.Router();

Router.get(UserRoutingURLs.PROFILE, async (request, response) => {
    let user = await JWTHelper.getCurrentUser(request);

    let teams = await TeamServices.findByUser(user);
    let projects = await ProjectServices.findAllByTeams(teams);

    response.render(ViewsResourcePaths.USER.PROFILE, {user,teams,projects})
});

export default Router
import Express from 'express'
import {
  ProjectRoutingURLs, TeamRoutingURLs,
} from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import Roles from '../../domain/models/enums/role.enums'
import TeamServices from '../../services/team.services'
import NotificationHelper from '../../helpers/notification.helper'
import ProjectServices from '../../services/project.services'
import RoleHelper from '../../helpers/role.helper'
import UserServices from '../../services/user.services'

const Router = Express.Router()

Router.get(ProjectRoutingURLs.CREATE, async (request, response) => {
  response.render(ViewsResourcePaths.PROJECT.CREATE)
})

Router.post(ProjectRoutingURLs.CREATE, async (request, response) => {
  let {name,description} = request.body;

  let project = {name,description};
  await ProjectServices.save(project);

  NotificationHelper.prepareInfo(request,'Project created!')
  response.redirect(ProjectRoutingURLs.ALL);
})

Router.get(ProjectRoutingURLs.ALL, async (request, response) => {
  let user = request.user;
  let role = RoleHelper.getHighestRoleFrom(user.roles);

  if (role === Roles.USER) {
    response.render(ViewsResourcePaths.PROJECT.ALL_USER, {})
  } else if (role === Roles.ADMIN) {
    let teams = await TeamServices.findAll();
    let projects = await ProjectServices.findAllWithoutTeam();

    response.render(ViewsResourcePaths.PROJECT.ALL_ADMIN, {teams: teams,projects: projects})
  }
})

Router.post(ProjectRoutingURLs.ASSIGN, async (request, response) => {
  let { project,team } = request.body

  project = await ProjectServices.findById(project);
  team = await TeamServices.findById(team);

  team.projects.push(project);
  await TeamServices.create(team)

  project.team = team;
  await ProjectServices.save(project)

  NotificationHelper.prepareInfo(request, 'Project assigned!')
  response.redirect(ProjectRoutingURLs.ALL)
})

export default Router
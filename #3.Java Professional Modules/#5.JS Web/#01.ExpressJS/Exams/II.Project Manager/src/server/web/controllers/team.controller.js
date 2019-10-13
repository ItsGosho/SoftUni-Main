import Express from 'express'
import { TeamRoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import Roles from '../../domain/models/enums/role.enums'
import TeamServices from '../../services/team.services'
import NotificationHelper from '../../helpers/notification.helper'
import RoleHelper from '../../helpers/role.helper'
import UserServices from '../../services/user.services'

const Router = Express.Router()

Router.get(TeamRoutingURLs.CREATE, async (request, response) => {
  response.render(ViewsResourcePaths.TEAM.CREATE, {})
})

Router.post(TeamRoutingURLs.CREATE, async (request, response) => {
  let { name } = request.body

  let team = { name }
  await TeamServices.create(team)

  NotificationHelper.prepareInfo(request, 'Team created!')
  response.redirect(TeamRoutingURLs.ALL)
})

Router.get(TeamRoutingURLs.ALL, async (request, response) => {
  let user = request.user
  let role = RoleHelper.getHighestRoleFrom(user.roles)

  if (role === Roles.USER) {
    response.render(ViewsResourcePaths.TEAM.ALL_USER, {})
  } else if (role === Roles.ADMIN) {
    let teams = await TeamServices.findAll();
    let users = await UserServices.findAll();

    response.render(ViewsResourcePaths.TEAM.ALL_ADMIN, {teams,users})
  }
})

Router.post(TeamRoutingURLs.ASSIGN, async (request, response) => {
  let { user,team } = request.body

  user = await UserServices.findById(user);
  team = await TeamServices.findById(team);

  team.members.push(user);
  await TeamServices.create(team)

  NotificationHelper.prepareInfo(request, 'Team assigned!')
  response.redirect(TeamRoutingURLs.ALL)
})


export default Router
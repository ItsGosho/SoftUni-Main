import Express from 'express'
import {  TeamRoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import Roles from '../../domain/models/enums/role.enums'

const Router = Express.Router()

Router.get(TeamRoutingURLs.CREATE, async (request, response) => {

  response.render(ViewsResourcePaths.TEAM.CREATE, {})
})

Router.post(TeamRoutingURLs.CREATE, async (request, response) => {

  response.send('<h1>Team create!</h1>')
})

Router.get(TeamRoutingURLs.ALL, async (request, response) => {

  let role = Roles.USER

  if (role === Roles.USER) {
    response.render(ViewsResourcePaths.TEAM.ALL_USER, {})
  } else if (role === Roles.ADMIN) {
    response.render(ViewsResourcePaths.TEAM.ALL_ADMIN, {})
  }
})

export default Router
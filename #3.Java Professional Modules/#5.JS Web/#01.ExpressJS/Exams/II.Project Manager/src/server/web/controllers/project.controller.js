import Express from 'express'
import {
  ProjectRoutingURLs,
} from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import Roles from '../../domain/models/enums/role.enums'

const Router = Express.Router()

Router.get(ProjectRoutingURLs.CREATE, async (request, response) => {

  response.render(ViewsResourcePaths.PROJECT.CREATE, {})
})

Router.post(ProjectRoutingURLs.CREATE, async (request, response) => {

  response.send('<h1>Project create!</h1>')
})

Router.get(ProjectRoutingURLs.ALL, async (request, response) => {

  let role = Roles.USER

  if (role === Roles.USER) {
    response.render(ViewsResourcePaths.PROJECT.ALL_USER, {})
  } else if (role === Roles.ADMIN) {
    response.render(ViewsResourcePaths.PROJECT.ALL_ADMIN, {})
  }
})

export default Router
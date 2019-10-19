import Express from 'express'
import { RoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'

const Router = Express.Router()

Router.get(RoutingURLs.HOME, async (request, response) => {
  let user = request.user

  if (user === null) {
    response.render(ViewsResourcePaths.OTHER.GUEST_HOME, {})
    return
  }

  switch (user.role) {
    case 'Admin':
      response.render(ViewsResourcePaths.OTHER.ADMIN_HOME, { user: request.user })
      break

    case 'User':
      response.render(ViewsResourcePaths.OTHER.USER_HOME, { user: request.user })
      break
  }
})

export default Router
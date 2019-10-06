import Express from 'express'
import { UserRoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'

const Router = Express.Router()

Router.get(UserRoutingURLs.PROFILE, async (request, response) => {

  response.render(ViewsResourcePaths.USER.PROFILE, {})
})

export default Router
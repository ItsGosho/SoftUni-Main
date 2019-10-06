import Express from 'express'
import { RoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'

const Router = Express.Router()

Router.get(RoutingURLs.HOME, async (request, response) => {

  response.render(ViewsResourcePaths.OTHER.HOME, {})
})

export default Router
import Express from 'express'
import { RoutingURLs, UserRoutingURLs } from '../../constants/web/routing.urls.constants'
import UserServices from '../../services/user.services'
import JWTHelper from '../helpers/jwt.helper'
import JWTServices from '../../services/jwt.services'
import RoleHelper from '../../helpers/role.helper'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import NotificationType from '../../constants/other/notification.types.constants'
import NotificationHelper from '../../helpers/notification.helper'

const Router = Express.Router()

Router.get(RoutingURLs.HOME, async (request, response) => {

  response.render(ViewsResourcePaths.OTHER.HOME, {})
})

export default Router
import NotificationHelper from '../../helpers/notification.helper'
import { RoutingURLs } from '../../constants/web/routing.urls.constants'

/*Note that before this middleware is executed a user must be attached to the request somehow*/

const RoleMiddleware = (requiredRole) => {
  return async (request, response, next) => {
    let user = request.user
    let role = user.role;

    if (role.toLowerCase() === requiredRole.toLowerCase()) {
      next()
      return
    }

    NotificationHelper.prepareError(request, `You must be ${requiredRole} to access this route!`)
    response.redirect(RoutingURLs.HOME)
  }
}

export default RoleMiddleware


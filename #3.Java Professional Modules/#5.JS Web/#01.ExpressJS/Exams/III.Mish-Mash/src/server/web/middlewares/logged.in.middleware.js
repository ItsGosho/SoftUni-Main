import JWTServices from '../../services/jwt.services'
import NotificationHelper from '../../helpers/notification.helper'
import { RoutingURLs, UserRoutingURLs } from '../../constants/web/routing.urls.constants'

const LoggedInMiddleware = async (request, response, next) => {
  let token = request.cookies.jwt

  if (token !== undefined && await JWTServices.isValid(token)) {
    next()
    return
  }

  NotificationHelper.prepareError(request, 'Please login to access this content!')
  response.redirect(RoutingURLs.HOME)
}

export default LoggedInMiddleware

import JWTHelper from '../helpers/jwt.helper'

const UserAttacherMiddleware = (app) => {
  return async (request, response, next) => {
    let user = await JWTHelper.getCurrentUser(request)

    request.user = user
    app.locals.user = user
    next()
  }
}

export default UserAttacherMiddleware

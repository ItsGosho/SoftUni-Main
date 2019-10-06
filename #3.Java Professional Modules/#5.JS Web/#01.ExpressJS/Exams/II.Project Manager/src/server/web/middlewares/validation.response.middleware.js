import NotificationHelper from '../../helpers/notification.helper'

const { validationResult: ValidationResult } = require('express-validator')

const ValidationResponseMiddleware = (request, response, next) => {
  const errors = ValidationResult(request)

  if (!errors.isEmpty()) {
    NotificationHelper.prepareError(request, errors.array()[0].msg)
    response.redirect('back')
    return
  }

  next()
}

export default ValidationResponseMiddleware
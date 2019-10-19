import NotificationType from '../constants/other/notification.types.constants'

const NotificationHelper = {
  prepareError (request, message) {
    request.flash(NotificationType.ERROR, message)
  },

  prepareInfo (request, message) {
    request.flash(NotificationType.INFO, message)
  },
}

export default NotificationHelper
import NotificationType from '../constants/other/notification.types.constants'

let handlebarsNotificationHelper = function () {
  let showForMS = 5000

  let notificationWrapperId = 'itsgosho-notification-wrapper'
  let notificationId = 'itsgosho-notification'
  let timeLeftId = 'itsgosho-notification-time_left'

  let notificationClass
  let type

  if (this.messages.info !== undefined) {
    type = NotificationType.INFO
    notificationClass = 'alert alert-info'
  } else if (this.messages.error !== undefined) {
    type = NotificationType.ERROR
    notificationClass = 'alert alert-danger'
  }

  return notificationClass !== undefined ? `
<div id="${notificationWrapperId}" onclick="closeNotification()">

    <div id="${notificationId}" class="${notificationClass}" role="alert" style="text-align: center">${this.messages[type]}
        <span> - [</span>
        <span id="${timeLeftId}">5</span>
        <span>]</span>
    </div>

    <script>

      function closeNotification () {
        let notification = document.getElementById('${notificationWrapperId}')
        notification.remove();
      }

      autoRemove(${showForMS})

      function autoRemove (time) {
        setTimeout(function () {
          document.getElementById('${notificationWrapperId}').remove()
        }, time)

        setInterval(function () {
          try {
            let timeLeftElement = document.getElementById('${timeLeftId}')
            let newTime = Number(timeLeftElement.textContent) - 1
            timeLeftElement.textContent = newTime
          } catch (e) {

          }
        }, 1000)
      }
    </script>
</div>
` : null
}

let areEqualHandlebarsHelper = (string1, string2, options) => {
  if (string1 === string2) {
    return options.fn(this)
  }
  return options.inverse(this)
}

export {
  handlebarsNotificationHelper,
  areEqualHandlebarsHelper
}
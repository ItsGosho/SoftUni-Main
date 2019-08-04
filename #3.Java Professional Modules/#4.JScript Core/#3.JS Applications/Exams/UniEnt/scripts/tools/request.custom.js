/*@ItsGosho*/
class CustomRequester extends Requester {

    constructor() {
        super();
        this._notificationError = true;
        this._notificationLoading = true;
    }

    includeNotificationError(bool) {
        this._notificationError = bool;
        return this;
    }

    includeNotificationLoading(bool) {
        this._notificationLoading = bool;
        return this;
    }

    showErrorNotification(error) {
        let errorMessage = error.responseJSON.description;
        NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
    }

    run(onDone, onFail) {

        let isErrorNotificationRequired = this._notificationError;
        let isLoadingNotificationRequired = this._notificationLoading;

        let errorNotificationFunction = this.showErrorNotification;
        let loadingNotificationHolder;

        $.ajax(
            {
                type: super.getRequestType(),
                url: super.getRequestUrl(),
                headers: super.getHeaders(),
                data: super.getData(),
                async: super.isAsync(),
                beforeSend: function () {
                    if (isLoadingNotificationRequired) {
                        loadingNotificationHolder = NotificationViewResolver.showNotification(NotificationType.LOADING, '');
                    }
                }
            }
        ).done(function (data) {
            if (onDone !== undefined) {
                onDone(data);
            }

            if (isLoadingNotificationRequired) {
                loadingNotificationHolder.remove();
            }

        }).fail(function (error) {

            if (isLoadingNotificationRequired) {
                loadingNotificationHolder.remove();
            }

            if (isErrorNotificationRequired) {
                errorNotificationFunction(error);
            }

            if (onFail !== undefined) {
                onFail(error);
            }
        });
    }

}
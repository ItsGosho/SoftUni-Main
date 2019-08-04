AuthenticationServices = {

    register(sammy, firstName, lastName, username, password, confirmPassword) {
        if (firstName.length < 2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.FIRST_NAME_TOO_SHORT);
            return;
        }

        if (lastName.length < 2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.LAST_NAME_TOO_SHORT);
            return;
        }

        if (username.length < 3) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.USERNAME_TOO_SHORT);
            return;
        }

        if (password.length < 6) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.PASSWORD_TOO_SHORT);
            return;
        }

        if (password !== confirmPassword) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.PASSWORDS_NOT_EQUAL);
            return;
        }

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        $.ajax({
                type: 'POST',
                url: DatabaseURLs.REGISTER_URL,
                headers: {
                    'Authorization': AuthenticationTypes.BASIC + ' ' + DatabaseConstants.AUTHENTICATION_TOKEN
                },
                data: {
                    firstName: firstName,
                    lastName: lastName,
                    username: username,
                    password: password
                }
            }
        ).done(function (data) {

            WebTools
                .clearParametersValue(
                    FieldName.AUTHENTICATION_REGISTRATION_FIRST_NAME,
                    FieldName.AUTHENTICATION_REGISTRATION_LAST_NAME,
                    FieldName.AUTHENTICATION_REGISTRATION_USERNAME,
                    FieldName.AUTHENTICATION_REGISTRATION_PASSWORD,
                    FieldName.AUTHENTICATION_REGISTRATION_REPEAT_PASSWORD
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.REGISTRATION_SUCCESSFUL);

            notificationLoading.remove();
            sammy.redirect(RoutingUrls.LOGIN_GET);

        }).fail(function (error) {
            notificationLoading.remove();
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });
    },

    login(sammy, username, password) {

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        $.ajax({
                type: 'POST',
                url: DatabaseURLs.LOGIN_URL,
                headers: {
                    'Authorization': AuthenticationTypes.BASIC + ' ' + DatabaseConstants.AUTHENTICATION_TOKEN
                },
                data: {
                    username: username,
                    password: password
                }
            }
        ).done(function (data) {

            WebTools
                .clearParametersValue(
                    FieldName.AUTHENTICATION_LOGIN_USERNAME,
                    FieldName.AUTHENTICATION_LOGIN_PASSWORD
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGIN_SUCCESSFUL);

            WebTools.addToSession(LocalStorageParam.AUTHENTICATION_TOKEN, data._kmd.authtoken);
            WebTools.addToSession(LocalStorageParam.FIRST_NAME, data.firstName);
            WebTools.addToSession(LocalStorageParam.FIRST_NAME, data.lastName);

            notificationLoading.remove();
            sammy.redirect(RoutingUrls.HOME_GET);
        }).fail(function (error) {
            notificationLoading.remove();
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });
    },

    logout(sammy, authenticationToken) {
        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        $.ajax({
                type: 'POST',
                url: DatabaseURLs.LOGOUT_URL,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + authenticationToken
                }
            }
        ).done(function (data) {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGOUT_SUCCESSFUL);

            WebTools.clearSession();

            notificationLoading.remove();
            sammy.redirect(RoutingUrls.LOGIN_GET);
        }).fail(function (error) {
            notificationLoading.remove();
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });
    },

    getUser() {
        let result;

        $.ajax({

            type: 'GET',
            url: DatabaseURLs.USER_INFO,
            headers: {'Authorization': AuthenticationTypes.KINVEY + ' ' + sessionStorage.getItem(LocalStorageParam.AUTHENTICATION_TOKEN)},
            async: false

        }).done(function (data) {
            result = data;
        }).fail(function (error) {
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

        return result;
    }

};
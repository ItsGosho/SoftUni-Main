AuthenticationServices = {

    register(sammy, username, password, confirmPassword) {

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

        AuthenticationRequests.makeRegisterRequest({
            username: username,
            password: password
        }, proceed);

        function proceed() {
            WebTools
                .clearParametersValue(
                    FieldName.AUTHENTICATION_REGISTRATION_USERNAME,
                    FieldName.AUTHENTICATION_REGISTRATION_PASSWORD,
                    FieldName.AUTHENTICATION_REGISTRATION_REPEAT_PASSWORD
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.REGISTRATION_SUCCESSFUL);

            sammy.redirect(RoutingUrls.LOGIN_GET);
        }
    },


    login(sammy, username, password) {


        AuthenticationRequests.makeLoginRequest({username: username, password: password}, proceed);

        function proceed(data) {

            WebTools
                .clearParametersValue(
                    FieldName.AUTHENTICATION_LOGIN_USERNAME,
                    FieldName.AUTHENTICATION_LOGIN_PASSWORD
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGIN_SUCCESSFUL);

            WebTools.addToSession(LocalStorageParam.AUTHENTICATION_TOKEN, data._kmd.authtoken);
            WebTools.addToSession(LocalStorageParam.USERNAME, data.username);

            sammy.redirect(RoutingUrls.HOME_GET);
        }
    },

    logout(sammy, authenticationToken) {

        AuthenticationRequests.makeLogoutRequest(authenticationToken, proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGOUT_SUCCESSFUL);
            WebTools.clearSession();
            sammy.redirect(RoutingUrls.LOGIN_GET);
        }
    },

    getUser() {

        let result;
        AuthenticationRequests
            .makeGetUserRequest(
                WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                , function (data) {
                    result = data;
                });


        return result;
    }

};
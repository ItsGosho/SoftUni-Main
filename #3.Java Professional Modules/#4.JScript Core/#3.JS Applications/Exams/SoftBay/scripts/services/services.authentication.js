const AuthenticationServices = {

    register(sammy, username, password, confirmPassword) {

        if (username.trim().length <= 0) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.USERNAME_EMPTY);
            return;
        }

        if (password.trim().length <= 0) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.PASSWORD_EMPTY);
            return;
        }

        if (password.trim() !== confirmPassword.trim()) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.PASSWORDS_NOT_EQUAL);
            return;
        }

        AuthenticationRequests.makeRegister({
            username: username,
            password: password,
            totalPurchases: 0
        }, proceed);

        function proceed() {

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.REGISTRATION_SUCCESSFUL);

            AuthenticationServices.login(sammy,username,password);
        }
    },


    login(sammy, username, password) {


        AuthenticationRequests.makeLogin({username: username, password: password}, proceed);

        function proceed(data) {

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGIN_SUCCESSFUL);

            WebTools.addToSession(LocalStorageParam.AUTHENTICATION_TOKEN, data._kmd.authtoken);
            WebTools.addToSession(LocalStorageParam.USERNAME, data.username);

            sammy.redirect(RoutingUrls.HOME_GET);
        }
    },

    logout(sammy, authenticationToken) {

        AuthenticationRequests.makeLogout(authenticationToken, proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.LOGOUT_SUCCESSFUL);
            WebTools.clearSession();
            sammy.redirect(RoutingUrls.HOME_GET);
        }
    },

    getUser() {

        let result;
        AuthenticationRequests
            .makeGetCurrentLoggedInUserInfo(
                WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                , function (data) {
                    result = data;
                });


        return result;
    }

};
const AuthenticationRequests = {

    makeRegister(data, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.REGISTER_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.BASIC + ' ' + DatabaseConstants.BTOA_TOKEN)
            .data(data)
            .run(done, error);
    },

    makeLogin(data, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.LOGIN_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.BASIC + ' ' + DatabaseConstants.BTOA_TOKEN)
            .data(data)
            .run(done, error);
    },

    makeLogout(authenticationToken, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.LOGOUT_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authenticationToken)
            .run(done, error);
    },

    makeGetCurrentLoggedInUserInfo(authenticationToken, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.USER_INFO)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authenticationToken)
            .async(false)
            .run(done, error);
    },
};
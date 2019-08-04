const AuthenticationRequests = {

    makeRegisterRequest(data, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.REGISTER_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.BASIC + ' ' + DatabaseConstants.BTOA_TOKEN)
            .data(data)
            .run(done, error);
    },

    makeLoginRequest(data, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.LOGIN_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.BASIC + ' ' + DatabaseConstants.BTOA_TOKEN)
            .data(data)
            .run(done, error);
    },

    makeLogoutRequest(authenticationToken, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.LOGOUT_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authenticationToken)
            .run(done, error);
    },

    makeGetUserRequest(authenticationToken, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.USER_INFO)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authenticationToken)
            .async(false)
            .run(done, error);
    }
};
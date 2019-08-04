const authenticationRoutingsGET = Sammy('#rooter', async function () {

    this.get(RoutingUrls.LOGIN_GET, function () {
        ViewResolver.showLogin();
    });

    this.get(RoutingUrls.REGISTER_GET, async function () {
        ViewResolver.showRegistration();
    });

    this.get(RoutingUrls.LOGOUT_GET, async function () {
        AuthenticationServices
            .logout(
                this,
                WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
            );
    });
});
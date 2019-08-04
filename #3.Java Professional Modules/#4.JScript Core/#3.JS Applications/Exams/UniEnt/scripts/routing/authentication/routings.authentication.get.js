const authenticationRoutingsGET = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.get(RoutingUrls.LOGIN_GET,async function () {
        AuthenticationViewResolver.showLogin();
    });

    this.get(RoutingUrls.REGISTER_GET, async function () {
        AuthenticationViewResolver.showRegistration();
    });

    this.get(RoutingUrls.LOGOUT_GET, async function () {
        AuthenticationServices
            .logout(
                this,
                WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
            );
    });
});
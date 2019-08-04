const authenticationRoutingsPOST = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.post(RoutingUrls.REGISTER_POST, function () {

        AuthenticationServices
            .register(
                this,
                this.params.username,
                this.params.password,
                this.params.rePassword
            );
    });

    this.post(RoutingUrls.LOGIN_POST, function () {

        AuthenticationServices
            .login
            (
                this,
                this.params.username,
                this.params.password
            );
    });
});
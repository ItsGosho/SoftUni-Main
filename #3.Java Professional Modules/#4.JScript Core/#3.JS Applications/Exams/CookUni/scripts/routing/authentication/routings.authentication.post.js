const authenticationRoutingsPOST = Sammy('#rooter', async function () {

    this.post(RoutingUrls.REGISTER_POST, function () {

        AuthenticationServices
            .register(
                this,
                this.params.firstName,
                this.params.lastName,
                this.params.username,
                this.params.password,
                this.params.repeatPassword
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
const AuthenticationViewResolver = {
    showRegistration() {
        CoreViewResolver.performBasics();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.REGISTER,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showLogin() {
        CoreViewResolver.performBasics();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.LOGIN,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showProfileCurrentLoggedIn() {
        CoreViewResolver.performBasics();
        let user = AuthenticationServices.getUser();

        HandleBarsTools
            .makeTemplate
            (
                {user},
                ViewPaths.USER_PROFILE,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },
};
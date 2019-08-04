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
};
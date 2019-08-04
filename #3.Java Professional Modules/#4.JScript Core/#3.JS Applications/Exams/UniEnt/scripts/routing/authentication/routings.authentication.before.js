const authenticationRoutingsBefore = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.before(RoutingUrls.LOGIN_GET, function () {
        if (WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.LOGIN_POST, function () {
        if (WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.REGISTER_GET, function () {
        if (WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.REGISTER_POST, function () {
        if (WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.LOGOUT_GET, function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
        return true;
    });

});
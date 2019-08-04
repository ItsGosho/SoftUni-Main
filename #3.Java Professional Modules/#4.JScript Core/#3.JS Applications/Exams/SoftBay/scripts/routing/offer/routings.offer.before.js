const offerRoutingsBefore = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.before(RoutingUrls.OFFER_ALL_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_CREATE_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_DELETE_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_DETAILS_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_EDIT_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_BUY_GET,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_CREATE_POST,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_DELETE_POST,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.OFFER_EDIT_POST,async function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

});
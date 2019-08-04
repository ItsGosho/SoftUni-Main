const recipeRoutingsBefore = Sammy('#rooter', async function () {

    this.before(RoutingUrls.RECIPE_SHARE_GET, function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.RECIPE_SHARE_POST, function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

    this.before(RoutingUrls.RECIPE_EDIT_PUT, function () {
        if (!WebTools.isLoggedIn()) {
            this.redirect(RoutingUrls.HOME_GET);
            return false;
        }
    });

});
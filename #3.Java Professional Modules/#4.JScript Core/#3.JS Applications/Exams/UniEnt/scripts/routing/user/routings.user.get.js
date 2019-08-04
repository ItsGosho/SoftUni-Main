const userRoutingsGet = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.get(RoutingUrls.USER_PROFILE_GET, async function () {
        UserViewResolver.showCurrentLoggedInUserProfile();
    });
});
const defaultRoutings = Sammy(Containers.ROUTER_CONTAINER, async function () {
    this.notFound = async function () {
        /*TODO: CHANGE IT*/
        console.log("The requested page wasn't found!");
    };

    this.get(RoutingUrls.HOME_GET, async function () {
        CoreViewResolver.showHome();
    });

});
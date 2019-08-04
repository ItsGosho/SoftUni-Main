const defaultRoutings = Sammy('#rooter', async function () {
    this.notFound = async function () {
        /*TODO: CHANGE IT*/
        console.log("The requested page wasnt found!");
    };

    this.get(RoutingUrls.HOME_GET, async function () {
        ViewResolver.showHome();
    });

});
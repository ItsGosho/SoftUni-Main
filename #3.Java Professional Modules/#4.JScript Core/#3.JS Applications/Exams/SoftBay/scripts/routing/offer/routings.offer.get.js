const offerRoutingsGet = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.get(RoutingUrls.OFFER_ALL_GET, async function () {
        OfferViewResolver.showAll();
    });

    this.get(RoutingUrls.OFFER_CREATE_GET, async function () {
        OfferViewResolver.showCreate();
    });

    this.get(RoutingUrls.OFFER_DELETE_GET, async function () {
        OfferViewResolver.showDelete(this.params['id']);
    });

    this.get(RoutingUrls.OFFER_DETAILS_GET, async function () {
        OfferViewResolver.showDetails(this.params['id']);
    });

    this.get(RoutingUrls.OFFER_EDIT_GET, async function () {
        OfferViewResolver.showEdit(this.params['id']);
    });

    this.get(RoutingUrls.OFFER_BUY_GET, async function () {
        let user = AuthenticationServices.getUser();

        let offer;
        OfferRequests.makeGetByID(this.params['id'], function (data) {
            offer = data;
        });

        OfferServices.buy(this,offer,user);
    });

});
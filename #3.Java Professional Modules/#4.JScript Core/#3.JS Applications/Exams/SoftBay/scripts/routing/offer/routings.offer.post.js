const offerRoutingsPost = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.post(RoutingUrls.OFFER_CREATE_POST, function () {

        let product = {
            'product':this.params.product,
            'description':this.params.description,
            'price':this.params.price,
            'pictureUrl':this.params.pictureUrl
        };

        OfferServices.create(
            this,
            product
        );
    });

    this.post(RoutingUrls.OFFER_DELETE_POST, function () {
        OfferServices.delete(
            this,
            this.params['id']
        );
    });

    this.post(RoutingUrls.OFFER_EDIT_POST, function () {

        let originalOffer;
        OfferRequests.makeGetByID(this.params['id'],function (data) {
            originalOffer = data;
        });

        originalOffer.product = this.params.product;
        originalOffer.description = this.params.description;
        originalOffer.price = this.params.price;
        originalOffer.pictureUrl = this.params.pictureUrl;

        OfferServices.edit(
            this,
            originalOffer
        );
    });


});
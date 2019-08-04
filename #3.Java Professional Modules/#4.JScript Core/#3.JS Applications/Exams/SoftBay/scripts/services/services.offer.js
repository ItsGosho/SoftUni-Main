const OfferServices = {

    create(sammy, offer) {

        if (offer.product.trim().length <= 0) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.OFFER_PRODUCT_EMPTY);
            return;
        }

        if (offer.description.trim().length <= 0) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.OFFER_DESCRIPTION_EMPTY);
            return;
        }

        if (offer.price.trim().length <= 0) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.OFFER_PRICE_EMPTY);
            return;
        }

        let st1 = offer.pictureUrl.startsWith('http://');
        let st2 = offer.pictureUrl.startsWith('https://');

        if (!st1 && !st2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.OFFER_IMAGE_NOT_RIGHT_FORMAT);
            return;
        }

        OfferRequests.makeCreate(offer, proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.OFFER_CREATION_SUCCESSFUL);

            sammy.redirect(RoutingUrls.OFFER_ALL_GET);
        }
    },

    delete(sammy, id) {

        let user = AuthenticationServices.getUser();
        let offer;

        OfferRequests.makeGetByID(id, function (data) {
            offer = data;
        });

        if (user._id !== offer._acl.creator) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, 'You cant delete!');
            return;
        }

        OfferRequests.makeDelete(id, proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.OFFER_DELETE_SUCCESSFUL);

            sammy.redirect(RoutingUrls.OFFER_ALL_GET);
        }
    },

    edit(sammy, offer) {

        let user = AuthenticationServices.getUser();

        if (user._id !== offer._acl.creator) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, 'You cant edit!');
            return;
        }

        OfferRequests.makeUpdate(offer, proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.OFFER_EDIT_SUCCESSFUL);

            sammy.redirect(RoutingUrls.OFFER_ALL_GET);
        }
    },

    buy(sammy, offer, user) {

        if (user._id === offer._acl.creator) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, 'You cant buy!');
            return;
        }

        if (user.totalPurchases === undefined) {
            user.totalPurchases = 0;
        }

        user.totalPurchases = Number(user.totalPurchases) + 1;

        /*TODO: DONT ASK WHY ....*/
        new CustomRequester()
            .type(RequestType.PUT)
            .url(DatabaseURLs.REGISTER_URL + '/' + user._id)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .data(user)
            .run(proceed, error);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, 'Offer buy successful');

            sammy.redirect(RoutingUrls.OFFER_ALL_GET);
        }

        function error() {

        }
    },

};
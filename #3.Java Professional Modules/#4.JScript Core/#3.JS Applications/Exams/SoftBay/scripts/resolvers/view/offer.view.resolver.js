const OfferViewResolver = {

    showCreate() {
        CoreViewResolver.performBasics();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.OFFER_CREATE,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showAll() {
        CoreViewResolver.performBasics();

        let user = AuthenticationServices.getUser();

        let offers;
        OfferRequests.makeGetAll(function (data) {
            offers = data;

            offers.forEach(x => {
                let userId = user._id;
                let creatorId = x._acl.creator;

                x.canEdit = userId === creatorId;
                x.canDelete = userId === creatorId;
                x.canBuy = userId !== creatorId;
            });
        });

        HandleBarsTools
            .makeTemplate
            (
                {offers},
                ViewPaths.OFFER_ALL,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showDelete(offerId) {
        CoreViewResolver.performBasics();

        let offer;
        OfferRequests.makeGetByID(offerId, function (data) {
            offer = data;
        });

        HandleBarsTools
            .makeTemplate
            (
                {offer},
                ViewPaths.OFFER_DELETE,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showDetails(offerId) {
        CoreViewResolver.performBasics();

        let offer;
        OfferRequests.makeGetByID(offerId, function (data) {
            offer = data;
        });

        HandleBarsTools
            .makeTemplate
            (
                {offer},
                ViewPaths.OFFER_DETAILS,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showEdit(offerId) {
        CoreViewResolver.performBasics();

        let offer;
        OfferRequests.makeGetByID(offerId, function (data) {
            offer = data;
        });

        HandleBarsTools
            .makeTemplate
            (
                {offer},
                ViewPaths.OFFER_EDIT,
                $(Containers.MAIN_CONTAINER_ID)
            );
    }

};
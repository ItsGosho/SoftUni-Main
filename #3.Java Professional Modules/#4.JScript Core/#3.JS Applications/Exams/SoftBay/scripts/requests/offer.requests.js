const OfferRequests = {

    makeCreate(data, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.DATABASE_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .data(data)
            .run(done, error);
    },

    makeGetAll(done, error) {
        new CustomRequester()
            .url(DatabaseURLs.DATABASE_URL)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .async(false)
            .run(done, error);
    },

    makeGetByID(id, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.DATABASE_URL + '/' + id)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .async(false)
            .run(done, error);
    },

    makeUpdate(data, done, error) {
        new CustomRequester()
            .type(RequestType.PUT)
            .url(DatabaseURLs.DATABASE_URL + '/' + data._id)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .data(data)
            .run(done, error);
    },

    makeDelete(id, done, error) {
        new CustomRequester()
            .type(RequestType.DELETE)
            .url(DatabaseURLs.DATABASE_URL + '/' + id)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN))
            .run(done, error);
    },

};
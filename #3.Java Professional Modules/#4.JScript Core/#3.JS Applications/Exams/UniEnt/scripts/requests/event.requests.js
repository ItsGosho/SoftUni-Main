const EventRequests = {

    makeOrganizeEventRequest(data, authorizationToken, done, error) {
        new CustomRequester()
            .type(RequestType.POST)
            .url(DatabaseURLs.EVENT)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .data(data)
            .run(done, error);
    },

    makeGetEventsRequest(authorizationToken, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.EVENT)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .async(false)
            .run(done, error);
    },

    makeGetEventsByCreatorRequest(creatorId, authorizationToken, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.EVENT + '?query={"_acl.creator":\"' + creatorId + '\"}')
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .async(false)
            .run(done, error);
    },

    makeGetEventByIdRequest(eventId, authorizationToken, done, error) {
        new CustomRequester()
            .url(DatabaseURLs.EVENT + '/' + eventId)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .async(false)
            .run(done, error);
    },

    makeDeleteEventRequest(eventId, authorizationToken, done, error) {
        new CustomRequester()
            .type(RequestType.DELETE)
            .url(DatabaseURLs.EVENT + '/' + eventId)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .run(done, error);
    },

    makeJoinEventRequest(data, eventId, authorizationToken, done, error) {
        new CustomRequester()
            .type(RequestType.PUT)
            .url(DatabaseURLs.EVENT + '/' + eventId)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .data(data)
            .run(done, error);
    },

    makeEditEventRequest(data, eventId, authorizationToken, done, error) {
        new CustomRequester()
            .type(RequestType.PUT)
            .url(DatabaseURLs.EVENT + '/' + eventId)
            .header(RequestHeaderType.AUTHORIZATION, AuthenticationTypes.KINVEY + ' ' + authorizationToken)
            .data(data)
            .run(done, error);
    }
};
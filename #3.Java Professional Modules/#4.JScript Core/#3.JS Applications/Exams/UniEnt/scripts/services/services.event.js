EventServices = {
    /*12:00*/
    /*212 rows of code to 132 = 80 diff*/
    organize(sammy, name, date, description, image, organizer) {

        if (name.length < 6) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.EVENT_NAME_TOO_SHORT);
            return;
        }

        let regexPart1 = new RegExp('^([0-9]+) ([A-Za-z]+)$');
        let regexPart2 = new RegExp('^([0-9]+) ([A-Za-z]+ - [0-9]+ [A-Z]+)$');

        if (!regexPart1.test(date) && !regexPart2.test(date)) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.EVENT_DATE_NOT_RIGHT_FORMAT);
            return;
        }

        if (description.length < 10) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.EVENT_DESCRIPTION_TOO_SHORT);
            return;
        }

        let st1 = image.startsWith('http://');
        let st2 = image.startsWith('https://');

        if (!st1 && !st2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.EVENT_IMAGE_NOT_RIGHT_FORMAT);
            return;
        }

        let event = {
            name: name,
            dateTime: date,
            description: description,
            imageURL: image,
            peopleInterestedIn: 0,
            organizer: organizer
        };

        EventRequests.makeOrganizeEventRequest(event, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), proceed);

        function proceed() {
            WebTools
                .clearParametersValue(
                    FieldName.EVENT_ORGANIZE_NAME,
                    FieldName.EVENT_ORGANIZE_DESCRIPTION,
                    FieldName.EVENT_ORGANIZE_DATE,
                    FieldName.EVENT_ORGANIZE_IMAGE
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.EVENT_ORGANIZE_SUCCESSFUL);

            sammy.redirect(RoutingUrls.HOME_GET);
        }

    },

    getEvents() {
        let result;

        EventRequests.makeGetEventsRequest(WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), function (data) {
            result = data;
        });

        return result;
    },

    getEventsByCreator(creatorId) {
        let result;

        EventRequests.makeGetEventsByCreatorRequest(creatorId, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), function (data) {
            result = data;
        });

        return result;
    },

    getEventById(eventId) {
        let result;

        EventRequests.makeGetEventByIdRequest(eventId, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), function (data) {
            result = data;
        });

        return result;
    },

    deleteEvent(user, event) {

        if (event._acl.creator !== user._id) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, 'You cant delete this event!');
            return;
        }

        EventRequests.makeDeleteEventRequest(event._id, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.EVENT_DELETE_SUCCESSFUL);
        }

    },

    joinEvent(user, event) {

        if (event._acl.creator === user._id) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, 'You cant join your event!');
            return;
        }

        event.peopleInterestedIn++;

        EventRequests.makeJoinEventRequest(event, event._id, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.EVENT_JOIN_SUCCESSFUL);
        }

    },

    edit(sammy, event) {

        EventRequests.makeEditEventRequest(event, event._id, WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN), proceed);

        function proceed() {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.EVENT_EDIT_SUCCESSFUL);

            sammy.redirect(RoutingUrls.HOME_GET);
        }
    }

};
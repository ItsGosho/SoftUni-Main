const EventViewResolver = {
    showOrganizeEvent() {
        CoreViewResolver.performBasics();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.EVENT_ORGANIZE,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showEventDetails(eventId) {
        CoreViewResolver.performBasics();

        let event = EventServices.getEventById(eventId);
        let user = AuthenticationServices.getUser();

        let canEdit = event._acl.creator === user._id;
        let canDelete = event._acl.creator === user._id;
        let canJoin = event._acl.creator !== user._id;

        HandleBarsTools
            .makeTemplate
            (
                {event, canEdit, canDelete, canJoin},
                ViewPaths.EVENT_DETAILS,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },

    showEditEvent(event) {
        CoreViewResolver.performBasics();

        HandleBarsTools
            .makeTemplate
            (
                {event},
                ViewPaths.EVENT_EDIT,
                $(Containers.MAIN_CONTAINER_ID)
            );
    }
};
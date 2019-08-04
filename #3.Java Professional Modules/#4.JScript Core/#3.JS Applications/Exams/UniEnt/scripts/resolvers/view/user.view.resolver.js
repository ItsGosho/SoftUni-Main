const UserViewResolver = {

    showCurrentLoggedInUserProfile() {
        CoreViewResolver.performBasics();

        let user = AuthenticationServices.getUser();
        let events = EventServices.getEventsByCreator(user._id);
        let totalOrganizedEvents = events.length;

        HandleBarsTools
            .makeTemplate
            (
                {
                    username: user.username,
                    totalOrganizedEvents: totalOrganizedEvents,
                    events: events
                },
                ViewPaths.USER_PROFILE,
                $(Containers.MAIN_CONTAINER_ID)
            );
    },
};
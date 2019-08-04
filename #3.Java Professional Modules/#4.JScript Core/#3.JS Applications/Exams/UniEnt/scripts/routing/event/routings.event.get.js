const eventRoutingsGet = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.get(RoutingUrls.EVENT_ORGANIZE_GET, async function () {
        EventViewResolver.showOrganizeEvent();
    });

    this.get(RoutingUrls.EVENT_VIEW_GET, async function () {
        EventViewResolver.showEventDetails(this.params['id']);
    });

    this.get(RoutingUrls.EVENT_DELETE_POST, async function () {

        let event = EventServices.getEventById(this.params['id']);
        let user = AuthenticationServices.getUser();

        EventServices.deleteEvent(
            user,
            event
        );

        this.redirect(RoutingUrls.HOME_GET);
    });

    this.get(RoutingUrls.EVENT_JOIN_POST, async function () {

        let event = EventServices.getEventById(this.params['id']);
        let user = AuthenticationServices.getUser();

        EventServices.joinEvent(
            user,
            event
        );

        this.redirect(RoutingUrls.EVENT_VIEW_GET.replace(':id',this.params['id']));
    });

    this.get(RoutingUrls.EVENT_EDIT_GET, async function () {

        let event = EventServices.getEventById(this.params['id']);

        EventViewResolver.showEditEvent(event);
    });
});
const eventRoutingsPost = Sammy(Containers.ROUTER_CONTAINER, async function () {

    this.post(RoutingUrls.EVENT_ORGANIZE_POST, function () {

        let organizer = WebTools.getParam(LocalStorageParam.USERNAME);
        EventServices
            .organize(
                this,
                this.params.name,
                this.params.dateTime,
                this.params.description,
                this.params.imageURL,
                organizer
            );
    });

    this.post(RoutingUrls.EVENT_EDIT_POST, function () {

        let eventId = this.params['id'];
        let event = EventServices.getEventById(eventId);

        event.name = this.params.name;
        event.dateTime = this.params.dateTime;
        event.description = this.params.description;
        event.imageURL = this.params.imageURL;

        EventServices
            .edit(
                this,
                event
            );
    });
});
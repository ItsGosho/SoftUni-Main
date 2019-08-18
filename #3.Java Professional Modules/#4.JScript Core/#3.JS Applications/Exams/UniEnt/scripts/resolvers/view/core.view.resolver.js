const CoreViewResolver = {

    showHome() {
        this.clear();
        this.showNavBar();
        this.showFooter();

        if (!WebTools.isLoggedIn()) {
            HandleBarsTools.makeTemplate
            (
                {},
                ViewPaths.GUEST_HOME,
                $(Containers.MAIN_CONTAINER_ID)
            );
        } else {
            let events = EventServices.getEvents();

            HandleBarsTools.makeTemplate
            (
                {events: events},
                ViewPaths.USER_HOME,
                $(Containers.MAIN_CONTAINER_ID)
            );
        }
    },

    showNavBar() {

        let navbarContainer = $(Containers.NAVBAR_CONTAINER_CLASS_SELECTOR);
        navbarContainer.empty();

        let navbar = $(
            HandleBarsTools.getTemplate
            ({
                isLoggedIn: WebTools.isLoggedIn(),
                username: WebTools.getParam(LocalStorageParam.USERNAME),
            }, ViewPaths.NAVBAR)
        );

        navbarContainer.append(navbar);
    },

    showFooter() {
        let footerContainer = $(Containers.FOOTER_CONTAINER_CLASS_SELECTOR);
        footerContainer.empty();

        let footer = $(WebTools.getHTMLFile(ViewPaths.FOOTER));

        footerContainer.append(footer);
    },

    performBasics(){
        this.clear();
        this.showNavBar();
        this.showFooter();
    },

    /*
    * Clears the main container which holds the main content of the page!
    * */
    clear() {
        $('#main_container').empty();
    }
};
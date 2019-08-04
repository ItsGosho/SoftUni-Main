const MAIN_CONTAINER = '#main_container';

const ViewResolver = {

    showHome() {
        this.clear();
        this.showNavBar();
        this.showFooter();

        if (!WebTools.isLoggedIn()) {
            HandleBarsTools.makeTemplate
            (
                {},
                ViewPaths.HOME,
                $(MAIN_CONTAINER)
            );
        } else {
            let recipes = RecipeServices.getUserRecipes();

            HandleBarsTools.makeTemplate
            (
                {recipes: recipes},
                ViewPaths.RECIPE_ALL,
                $(MAIN_CONTAINER)
            );
            console.log();
        }
    },

    showRegistration() {
        this.clear();
        this.showNavBar();
        this.showFooter();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.REGISTER,
                $(MAIN_CONTAINER)
            );
    },

    showLogin() {
        this.clear();
        this.showNavBar();
        this.showFooter();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.LOGIN,
                $(MAIN_CONTAINER)
            );
    },

    showNavBar() {

        let navbarContainer = $(`#rooter header`);
        navbarContainer.empty();

        let navbar = $(
            HandleBarsTools.getTemplate
            ({
                isLoggedIn: WebTools.isLoggedIn(),
                firstName: WebTools.getParam(LocalStorageParam.FIRST_NAME),
                lastName: WebTools.getParam(LocalStorageParam.LAST_NAME)
            }, ViewPaths.NAVBAR)
        );

        navbarContainer.append(navbar);
    },

    showFooter() {
        let footerContainer = $(`#rooter footer`);
        footerContainer.empty();

        let footer = $(WebTools.getHTMLFile(ViewPaths.FOOTER));

        footerContainer.append(footer);
    },

    showRecipeShare() {
        this.clear();
        this.showNavBar();
        this.showFooter();

        HandleBarsTools
            .makeTemplate
            (
                {},
                ViewPaths.RECIPE_CREATE,
                $(MAIN_CONTAINER)
            );
    },

    showRecipeView(recipeId) {
        this.clear();
        this.showNavBar();
        this.showFooter();

        let recipe = RecipeServices.getRecipe(recipeId);
        let user = AuthenticationServices.getUser();

        let canEdit = recipe._acl.creator === user._id;
        let canArchive = recipe._acl.creator === user._id;
        let canLike = recipe._acl.creator !== user._id;

        HandleBarsTools
            .makeTemplate
            (
                {recipe, canEdit, canArchive, canLike},
                ViewPaths.RECIPE_VIEW,
                $(MAIN_CONTAINER)
            );
    },

    showRecipeEditView(recipeId) {
        this.clear();
        this.showNavBar();
        this.showFooter();

        let recipe = RecipeServices.getRecipe(recipeId);
        HandleBarsTools
            .makeTemplate
            (
                {recipe},
                ViewPaths.RECIPE_EDIT,
                $(MAIN_CONTAINER)
            );
    },

    /*
    * Clears the main container which holds the main content of the page!
    * */
    clear() {
        $('#main_container').empty();
    }
};
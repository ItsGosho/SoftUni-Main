const recipeRoutingsGet = Sammy('#rooter', async function () {

    this.get(RoutingUrls.RECIPE_SHARE_GET,async function () {
        ViewResolver.showRecipeShare();
    });

    this.get(RoutingUrls.RECIPE_VIEW_GET,async function () {
        let recipeId = this.params['id'];

        ViewResolver.showRecipeView(recipeId);
    });

    this.get(RoutingUrls.RECIPE_EDIT_GET,async function () {
        let recipeId = this.params['id'];

        ViewResolver.showRecipeEditView(recipeId);
    });

});
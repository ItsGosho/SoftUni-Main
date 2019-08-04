const recipeRoutingsPost = Sammy('#rooter', async function () {

    this.post(RoutingUrls.RECIPE_SHARE_POST, function () {

        RecipeServices
            .share(
                this,
                this.params.meal,
                this.params.ingredients.trim().split(new RegExp('\\s+')),
                this.params.prepMethod,
                this.params.description,
                this.params.foodImageURL,
                this.params.category
            );

    });

    this.get(RoutingUrls.RECIPE_LIKE_PUT, function () {

        let recipeId = this.params['id'];
        let user = AuthenticationServices.getUser();
        let recipe = RecipeServices.getRecipe(recipeId);

        RecipeServices
            .likeRecipe(
                user,
                recipe
            );
        this.redirect(RoutingUrls.RECIPE_VIEW_GET.replace(':id', recipeId));
    });

    this.get(RoutingUrls.RECIPE_ARCHIVE_DELETE, function () {

        let recipeId = this.params['id'];
        let user = AuthenticationServices.getUser();
        let recipe = RecipeServices.getRecipe(recipeId);

        RecipeServices
            .removeRecipe(
                user,
                recipe
            );
        this.redirect(RoutingUrls.HOME_GET);
    });

    this.post(RoutingUrls.RECIPE_EDIT_PUT, function () {

        let recipeId = this.params['id'];
        let user = AuthenticationServices.getUser();
        let recipe = RecipeServices.getRecipe(recipeId);

        RecipeServices
            .edit(
                this,
                this.params['id'],
                this.params.meal,
                this.params.ingredients.trim().split(new RegExp(',')),
                this.params.prepMethod,
                this.params.description,
                this.params.foodImageURL,
                this.params.category
            )
        ;
    });

});
RecipeServices = {

    share(sammy, meal, ingredients, preparationMethod, description, foodImageURL, category) {

        if (meal.length < 4) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.MEAL_NAME_TOO_SHORT);
            return;
        }

        if (ingredients.length < 2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.INGREDIENTS_NOT_ENOUGH);
            return;
        }

        if (preparationMethod.length < 10) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.PREPARATION_METHOD_TOO_SHORT);
            return;
        }

        if (description.length < 10) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.DESCRIPTION_TOO_SHORT);
            return;
        }

        let st1 = foodImageURL.startsWith('http://');
        let st2 = foodImageURL.startsWith('https://');

        if (!st1 && !st2) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.FOOD_IMG_URL_IS_WRONG);
            return;
        }

        let validCategories = [
            'Vegetables and legumes/beans',
            'Fruits', 'Grain Food',
            'Milk, cheese, eggs and alternatives',
            'Lean meats and poultry, fish and alternatives'
        ];

        if (!validCategories.includes(category)) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, ErrorMessages.CATEGORY_NOT_EXISTING);
            return;
        }

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        /*Category IMG*/
        let map = new Map();
        map.set('Grain Food', 'https://cdn.pixabay.com/photo/2014/12/11/02/55/corn-syrup-563796__340.jpg');
        map.set('Vegetables and legumes/beans', 'https://cdn.pixabay.com/photo/2017/10/09/19/29/eat-2834549__340.jpg');
        map.set('Fruits', 'https://cdn.pixabay.com/photo/2017/06/02/18/24/fruit-2367029__340.jpg');
        map.set('Lean meats and poultry, fish and alternatives', 'https://t3.ftcdn.net/jpg/01/18/84/52/240_F_118845283_n9uWnb81tg8cG7Rf9y3McWT1DT1ZKTDx.jpg');
        map.set('Milk, chees, eggs and alternatives', 'https://image.shutterstock.com/image-photo/assorted-dairy-products-milk-yogurt-260nw-530162824.jpg');

        let test = map.get(category);
        $.ajax({
                type: 'POST',
                url: DatabaseURLs.RECIPE,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                data: {
                    meal: meal,
                    ingredients: ingredients,
                    prepMethod: preparationMethod,
                    description: description,
                    categoryImageURL: map.get(category),
                    foodImageURL: foodImageURL,
                    category: category,
                    likesCounter: 0
                }
            }
        ).done(function (data) {

            WebTools
                .clearParametersValue(
                    FieldName.RECIPE_SHARE_MEAL,
                    FieldName.RECIPE_SHARE_INGREDIENTS,
                    FieldName.RECIPE_SHARE_METHOD,
                    FieldName.RECIPE_SHARE_DESCRIPTION,
                    FieldName.RECIPE_SHARE_IMG_URL
                );

            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.RECIPE_SHARE_SUCCESSFUL);

            notificationLoading.remove();
            sammy.redirect(RoutingUrls.HOME_GET);
        }).fail(function (error) {
            notificationLoading.remove();
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

    },

    getUserRecipes() {

        let result;
        $.ajax({
                type: 'GET',
                url: DatabaseURLs.RECIPE,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                async: false
            }
        ).done(function (data) {
            result = data;
        }).fail(function (error) {
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

        return result;
    },

    getRecipe(recipeId) {
        let result;
        $.ajax({
                type: 'GET',
                url: DatabaseURLs.RECIPE + '/' + recipeId,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                async: false
            }
        ).done(function (data) {
            result = data;
        }).fail(function (error) {
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

        return result;
    },

    likeRecipe(user, recipe) {

        if (recipe._acl.creator === user._id) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, NotificationMessages.RECIPE_CANT_LIKE);
            return;
        }

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');
        recipe.likesCounter++;

        $.ajax({
                type: 'PUT',
                url: DatabaseURLs.RECIPE + '/' + recipe._id,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                data: recipe
            }
        ).done(function (data) {
            notificationLoading.remove();
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.RECIPE_LIKED_SUCCESSFUL);
        }).fail(function (error) {
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

    },

    removeRecipe(user, recipe) {

        if (recipe._acl.creator !== user._id) {
            NotificationViewResolver.showNotification(NotificationType.ERROR, NotificationMessages.RECIPE_CANT_DELETE);
            return;
        }

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        $.ajax({
                type: 'DELETE',
                url: DatabaseURLs.RECIPE + '/' + recipe._id,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                data: recipe
            }
        ).done(function (data) {
            notificationLoading.remove();
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.RECIPE_REMOVED_SUCCESSFUL);
        }).fail(function (error) {
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

    },

    edit(sammy, recipeId, meal, ingredients, preparationMethod, description, foodImageURL, category) {

        let notificationLoading = NotificationViewResolver.showNotification(NotificationType.LOADING, '');

        /*Category IMG*/
        let map = new Map();
        map.set('Grain Food', 'https://cdn.pixabay.com/photo/2014/12/11/02/55/corn-syrup-563796__340.jpg');
        map.set('Vegetables and legumes/beans', 'https://cdn.pixabay.com/photo/2017/10/09/19/29/eat-2834549__340.jpg');
        map.set('Fruits', 'https://cdn.pixabay.com/photo/2017/06/02/18/24/fruit-2367029__340.jpg');
        map.set('Lean meats and poultry, fish and alternatives', 'https://t3.ftcdn.net/jpg/01/18/84/52/240_F_118845283_n9uWnb81tg8cG7Rf9y3McWT1DT1ZKTDx.jpg');
        map.set('Milk, chees, eggs and alternatives', 'https://image.shutterstock.com/image-photo/assorted-dairy-products-milk-yogurt-260nw-530162824.jpg');

        $.ajax({
                type: 'PUT',
                url: DatabaseURLs.RECIPE + '/' + recipeId,
                headers: {
                    'Authorization': AuthenticationTypes.KINVEY + ' ' + WebTools.getParam(LocalStorageParam.AUTHENTICATION_TOKEN)
                },
                data: {
                    meal: meal,
                    ingredients: ingredients,
                    prepMethod: preparationMethod,
                    description: description,
                    categoryImageURL: map.get(category),
                    foodImageURL: foodImageURL,
                    category: category
                }
            }
        ).done(function (data) {
            NotificationViewResolver.showNotification(NotificationType.SUCCESS, NotificationMessages.RECIPE_EDITED_SUCCESSFUL);

            notificationLoading.remove();
            sammy.redirect(RoutingUrls.HOME_GET);
        }).fail(function (error) {
            notificationLoading.remove();
            let errorMessage = error.responseJSON.description;
            NotificationViewResolver.showNotification(NotificationType.ERROR, errorMessage);
        });

    },

};
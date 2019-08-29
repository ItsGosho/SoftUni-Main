const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const UserServices = require('../../services/user.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.USER.LOGIN_GET, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.LOGIN);
});

Router.post(RoutingURLs.USER.LOGIN_GET, async (request, response) => {
    let {username, password} = request.body;

    if (await UserServices.isCredentialsValid(username, password)) {
        let token = await UserServices.proceedToken(username);

        response.cookie('jwt', token.token, {maxAge: 86_400_000, httpOnly: true});
        response.redirect(RoutingURLs.BASE.HOME);
        return;
    }

    response.send('The provided credentials are invalid!');
});

Router.get(RoutingURLs.USER.REGISTER_GET, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.REGISTER);
});

Router.post(RoutingURLs.USER.REGISTER_POST, (request, response) => {
    let {username, password, confirmedPassword, firstName, lastName, age, gender} = request.body;

    if (password !== confirmedPassword) {
        response.send('Passwords doesn\'t match');
        return;
    }

    let user = {
        username,
        password,
        firstName,
        lastName,
        age,
        gender
    };

    UserServices.register(user);
    response.redirect(RoutingURLs.BASE.HOME);
});


module.exports = Router;
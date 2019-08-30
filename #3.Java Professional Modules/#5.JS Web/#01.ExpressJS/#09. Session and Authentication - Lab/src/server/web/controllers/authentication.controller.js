const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const UserServices = require('../../services/user.services');
const JWTServices = require('../../services/jwt.token.services');
const ViewPaths = require('../../constants/view.path.constants');
const JWTHelper = require('../helpers/jwt.helper');

Router.get(RoutingURLs.USER.LOGIN, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.LOGIN);
});

Router.post(RoutingURLs.USER.LOGIN, async (request, response) => {
    let {username, password} = request.body;

    if (await UserServices.isCredentialsValid(username, password)) {
        let token = await UserServices.proceedToken(username);

        JWTHelper.attachToken(token.token, response);
        response.redirect(RoutingURLs.BASE.HOME);
        return;
    }

    response.send('The provided credentials are invalid!');
});

Router.get(RoutingURLs.USER.REGISTER, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.REGISTER);
});

Router.post(RoutingURLs.USER.REGISTER, (request, response) => {
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

Router.get(RoutingURLs.USER.LOGOUT, async (request, response) => {
    let user = await JWTHelper.getCurrentUser(request);

    if (user !== null) {

        await JWTServices.removeAllByUserId(user.id);
        response.clearCookie('jwt');
        response.redirect(RoutingURLs.BASE.HOME);
        return;
    }

    response.send('<h1>You aren\'t logged in!</h1>')
});


module.exports = Router;
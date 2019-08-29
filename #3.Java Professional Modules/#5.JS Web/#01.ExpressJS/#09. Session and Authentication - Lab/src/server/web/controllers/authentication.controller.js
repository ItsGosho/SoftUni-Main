const Router = require('express').Router();
const RoutingURLs = require('../../constants/routing.urls');
const UserServices = require('../../services/user.services');
const ViewPaths = require('../../constants/view.path.constants');

Router.get(RoutingURLs.USER.LOGIN_GET, (request, response) => {
    response.render(ViewPaths.AUTHENTICATION.LOGIN);
});

Router.post(RoutingURLs.USER.LOGIN_GET, async (request, response) => {
    let {username, password} = request.body;

    let isValid = await UserServices.login(username, password);

    if (isValid) {
        response.send('Successful!');
        return;
    }

    response.send('Failed!');
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
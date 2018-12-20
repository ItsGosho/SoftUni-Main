const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_rJV1Rm2yV';
const APP_SECRET = '14e840b7d45d459b948d854aeb8b4741';
const MASTER_SECRET = 'ca036ea141e245c29b80e896d9e72768';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};
const AUTH_HEADERS_MASTER = {'Authorization': "Basic " + btoa(APP_KEY + ":" + MASTER_SECRET)};
let CURRENT_LOGGED_USER = null;

function isAuthorized() {
    if (sessionStorage.getItem("authToken") == null) {
        return false;
    } else {
        return true;
    }
}

function login(username, password) {
    let isSuccessful = false;

        $.ajax({
            method: "post",
            headers: AUTH_HEADERS,
            url: BASE_URL + "user/" + APP_KEY+"/login",
            async: false,
            data: {
                username: username,
                password: password
            },
            success: function (result) {
                addSessionData(result._kmd.authtoken, result._id);
                isSuccessful = true;
            },
            error: function (error) {
                console.log(error);
            }
        });

    return isSuccessful;
}

function register(username, password, repeatPassword, firstName, lastName, email, telephone) {

    let isSuccessful = false;
    if (password === repeatPassword) {
        $.ajax({
            method: "post",
            headers: AUTH_HEADERS,
            url: BASE_URL + "user/" + APP_KEY+"/",
            data: {
                username: username,
                password: password,
                firstName: firstName,
                lastName: lastName,
                email: email,
                telephone: telephone
            },
            async: false,
            success: function (result) {
                console.log(result);
                addSessionData(result._kmd.authtoken, result._id);
                isSuccessful = true;
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    return isSuccessful;
}

function getUserData(id) {
    let userData = null;

    $.ajax({
        method: "get",
        headers: AUTH_HEADERS_MASTER,
        url: BASE_URL + "user/" + APP_KEY+"/"+id,
        async: false,
        success: function (result) {
            userData = result;
        },
        error: function (error) {
            console.log(error);
        }
    });

    return userData;
}

function getAllUsers() {
    let userData = null;

    $.ajax({
        method: "get",
        headers: AUTH_HEADERS_MASTER,
        url: BASE_URL + "user/" + APP_KEY,
        async: false,
        success: function (result) {
            userData = result;
        },
        error: function (error) {
            console.log(error);
        }
    });

    return userData;
}

function addSessionData(authToken, id) {
    sessionStorage.setItem("authToken", authToken);
    sessionStorage.setItem("id", id);
}

function updateUserData(firstName, lastName, email, telephone) {

    $.ajax({
        method: "put",
        headers: AUTH_HEADERS_MASTER,
        url: BASE_URL+"user/"+APP_KEY+"/"+sessionStorage.getItem("id"),
        async: false,
        data:{
            firstName:firstName,
            lastName:lastName,
            email:email,
            telephone:telephone
        },
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getCurrentLoggedUser() {
    return getUserData(sessionStorage.getItem("id"));
}
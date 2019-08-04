const DatabaseConstants = {
    BASE_URL: 'https://baas.kinvey.com',
    APP_KEY: 'kid_BJUPhtuWr',
    APP_SECRET: '3754a63683264cde9861f1979249ddd6',
    AUTHENTICATION_TOKEN: 'a2lkX0JKVVBodHVXcjozZDMzYWY4NGNmMTA0NzFmOTY3MDNjZWQ2YjMyMjcyOA==',
    CONTENT_TYPE: 'application/json'
};

const DatabaseURLs = {
    REGISTER_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY,
    LOGIN_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/login',
    LOGOUT_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_logout',
    USER_INFO: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_me',

    RECIPE: DatabaseConstants.BASE_URL + '/appdata/' + DatabaseConstants.APP_KEY + '/recipes'
};

const AuthenticationTypes = {
    BASIC: 'Basic',
    KINVEY: 'Kinvey'
};
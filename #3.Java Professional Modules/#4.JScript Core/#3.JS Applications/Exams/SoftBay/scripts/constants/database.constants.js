const DatabaseConstants = {
    BASE_URL: 'https://baas.kinvey.com',
    APP_KEY: 'kid_rk1FXbEQH',
    APP_SECRET: 'ff33f0bfae294dbeb08ff7f7ce84c846',
    BTOA_TOKEN: btoa('kid_rk1FXbEQH:ff33f0bfae294dbeb08ff7f7ce84c846'),
    CONTENT_TYPE: 'application/json'
};

const DatabaseURLs = {
    REGISTER_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY,
    LOGIN_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/login',
    LOGOUT_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_logout',
    USER_INFO: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_me',

    DATABASE_URL: DatabaseConstants.BASE_URL + '/appdata/' + DatabaseConstants.APP_KEY + '/offers'
};

const AuthenticationTypes = {
    BASIC: 'Basic',
    KINVEY: 'Kinvey'
};
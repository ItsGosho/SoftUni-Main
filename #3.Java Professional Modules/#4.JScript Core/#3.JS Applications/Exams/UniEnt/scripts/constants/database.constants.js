const DatabaseConstants = {
    BASE_URL: 'https://baas.kinvey.com',
    APP_KEY: 'kid_H1OnWfczr',
    APP_SECRET: 'c0c92e27143746369863d5d590cc267e',
    BTOA_TOKEN: btoa('kid_H1OnWfczr:c0c92e27143746369863d5d590cc267e'),
    CONTENT_TYPE: 'application/json'
};

const DatabaseURLs = {
    REGISTER_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY,
    LOGIN_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/login',
    LOGOUT_URL: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_logout',
    USER_INFO: DatabaseConstants.BASE_URL + '/user/' + DatabaseConstants.APP_KEY + '/_me',

    EVENT: DatabaseConstants.BASE_URL + '/appdata/' + DatabaseConstants.APP_KEY + '/events'
};

const AuthenticationTypes = {
    BASIC: 'Basic',
    KINVEY: 'Kinvey'
};
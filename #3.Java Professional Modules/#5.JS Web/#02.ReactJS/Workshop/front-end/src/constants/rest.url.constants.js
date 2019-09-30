const SERVER_URL = 'http://localhost:9999';

const RestURLs = {
    AUTHENTICATION: {
        LOGIN: SERVER_URL + '/auth/login',
        REGISTER: SERVER_URL + '/auth/signup',
        LOGOUT: SERVER_URL + '/auth/logout',
    },
};

export default RestURLs;
const SERVER_URL = 'http://localhost:9999';

const RestURLs = {
    AUTHENTICATION: {
        LOGIN: SERVER_URL + '/auth/login',
        REGISTER: SERVER_URL + '/auth/signup',
        LOGOUT: SERVER_URL + '/auth/logout',
    },

    BOOK: {
        ALL: SERVER_URL + '/books/all'
    }
};

export default RestURLs;
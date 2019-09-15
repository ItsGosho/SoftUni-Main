const SERVER_URL = 'http://localhost:9999';

const RestURLs = {
    AUTHENTICATION: {
        LOGIN: SERVER_URL + '/auth/login',
        REGISTER: SERVER_URL + '/auth/register',
        LOGOUT: SERVER_URL + '/auth/logout',
    },
    MOVIE: {
        CREATE: SERVER_URL + '/movies/create',
        ALL: SERVER_URL + '/movies/all'
    }
};

export default RestURLs;
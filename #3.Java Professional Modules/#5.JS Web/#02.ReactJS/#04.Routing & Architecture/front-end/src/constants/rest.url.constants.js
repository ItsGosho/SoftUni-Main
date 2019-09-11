const SERVER_URL = 'http://localhost:9999';

const RestURLs = {
    AUTHENTICATION: {
        LOGIN: SERVER_URL + '/auth/signin',
        REGISTER: SERVER_URL + '/auth/signup',
    },
    MOVIE: {
        CREATE: SERVER_URL + '/feed/movie/create',
        ALL: SERVER_URL + '/feed/movies'
    }
};

export default RestURLs;
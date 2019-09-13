const RoutingURLs = {
    USER: {
        LOGIN: '/auth/login',
        REGISTER: '/auth/register',
        LOGOUT: '/auth/logout',
    },
    MOVIE: {
        CREATE: '/movies/create',
        ALL: '/movies/all'
    }
};

const {
    USER: UserRoutingURLs,
    MOVIE: MovieRoutingURLs,
} = RoutingURLs;

export {
    UserRoutingURLs,
    MovieRoutingURLs
};
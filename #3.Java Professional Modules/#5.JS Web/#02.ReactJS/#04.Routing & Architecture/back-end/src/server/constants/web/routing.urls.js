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

const UserRoutingURLs = RoutingURLs.USER;
const MovieRoutingURLs = RoutingURLs.MOVIE;

export {
    UserRoutingURLs,
    MovieRoutingURLs
}
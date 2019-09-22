const RoutingURLs = {
    USER: {
        LOGIN: '/auth/login',
        REGISTER: '/auth/signup',
        LOGOUT: '/auth/logout',
    },
    BOOK: {
        CREATE: '/book/create',
        EDIT: '/book/edit/:id',
        ALL: '/book/all',
        REVIEW: '/book/review/:id',
        LIKE: '/book/like/:id',
        UNLIKE: '/book/unlike/:id',
        DELETE: '/book/delete/:id',
    }
};

const UserRoutingURLs = RoutingURLs.USER;
const BookRoutingURLs = RoutingURLs.BOOK;

export {
    UserRoutingURLs,
    BookRoutingURLs
}
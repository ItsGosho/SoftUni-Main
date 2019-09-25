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
    },
    STATISTICS: {
        TOTAL_USERS: '/statistics/total/users',
        TOTAL_BOOKS: '/statistics/total/books',
        TOTAL_ORDERS: '/statistics/total/orders',
    },
    ORDER: {
        CREATE: '/orders/create',
        MY: '/orders/my',
        PENDING: '/orders/pending',
        APPROVE: '/orders/approve/:id',
    }
};

const UserRoutingURLs = RoutingURLs.USER;
const BookRoutingURLs = RoutingURLs.BOOK;
const OrderRoutingURLs = RoutingURLs.ORDER;
const StatisticsRoutingURLs = RoutingURLs.STATISTICS;

export {
    UserRoutingURLs,
    BookRoutingURLs,
    OrderRoutingURLs,
    StatisticsRoutingURLs
}
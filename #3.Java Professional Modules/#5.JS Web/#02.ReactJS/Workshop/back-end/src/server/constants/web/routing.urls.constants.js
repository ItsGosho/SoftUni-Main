const RoutingURLs = {
    USER: {
        LOGIN: '/auth/login',
        REGISTER: '/auth/signup',
        LOGOUT: '/auth/logout',
    },
    BOOK: {
        CREATE: '/books/create',
        EDIT: '/books/edit/:id',
        ALL: '/books/all',
        REVIEW: '/books/review/:id',
        LIKE: '/books/like/:id',
        UNLIKE: '/books/unlike/:id',
        DELETE: '/books/delete/:id',
    },
    STATISTICS: {
        TOTAL_USERS: '/statistics/total/users',
        TOTAL_BOOKS: '/statistics/total/books',
        TOTAL_ORDERS: '/statistics/total/orders',
    },
    ORDER: {
        CREATE: '/orders/create',
        MY: '/orders/my',
        ALL: '/orders/all',
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
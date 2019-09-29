const RoutingURLs = {

    HOME: '/',

    OTHER: {
        STORE: '/store',
        CART: '/cart',
    },

    ORDER: {
        PENDING: '/orders/pending',
        MY: '/orders/my',
    },

    BOOK: {
        CREATE: '/books/create',
        DETAILS: '/books/details/:id',
    },

    AUTHENTICATION: {
        LOGIN: '/auth/login',
        REGISTER: '/auth/register',
        LOGOUT: '/auth/logout',
    },
};

export default RoutingURLs;
const BASE = {
    HOME: '/',
};

const USER = {
    LOGIN: '/auth/login',
    REGISTER: '/auth/register',
    LOGOUT: '/auth/logout',
};

const PRODUCT = {
    ADD: '/product/add',
    EDIT: '/product/edit/:id',
    BUY: '/product/buy/:id',
    DELETE: '/product/delete/:id',
};

const CATEGORY = {
    CREATE: '/category/add',
    ALL_PRODUCT_BY_CATEGORY: '/category/:category/products',
};

module.exports = {
    BASE,
    USER,
    PRODUCT,
    CATEGORY
};
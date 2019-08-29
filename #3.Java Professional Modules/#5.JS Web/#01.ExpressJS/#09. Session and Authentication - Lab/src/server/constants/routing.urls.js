const BASE = {
    HOME: '/',
};

const USER = {
    LOGIN_GET: '/auth/login',
    LOGIN_POST: '/auth/login',

    REGISTER_GET: '/auth/register',
    REGISTER_POST: '/auth/register',

    LOGOUT: '/auth/logout',
};

const PRODUCT = {
    ADD_GET: '/product/add',
    ADD_POST: '/product/add',

    EDIT_GET: '/product/edit/:id',
    EDIT_POST: '/product/edit/:id',

    BUY_GET: '/product/buy/:id',
    BUY_POST: '/product/buy/:id',

    DELETE_GET: '/product/delete/:id',
    DELETE_POST: '/product/delete/:id',
};

const CATEGORY = {
    CREATE_GET: '/category/add',
    CREATE_POST: '/category/add',
    ALL_PRODUCT_BY_CATEGORY: '/category/:category/products',
};

module.exports = {
    BASE,
    USER,
    PRODUCT,
    CATEGORY
};
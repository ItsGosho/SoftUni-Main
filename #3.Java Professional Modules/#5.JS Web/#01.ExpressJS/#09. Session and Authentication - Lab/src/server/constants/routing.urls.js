const URL = {
    HOME: '/',
    CREATE_PRODUCT: '/product/add',

    CATEGORY_CREATE: '/category/add',
    ALL_PRODUCT_BY_CATEGORY: '/category/:category/products',

    EDIT_PRODUCT_GET: '/product/edit/:id',
    EDIT_PRODUCT_POST: '/product/edit/:id',

    BUY_PRODUCT_GET: '/product/buy/:id',
    BUY_PRODUCT_POST: '/product/buy/:id',

    DELETE_PRODUCT_GET: '/product/delete/:id',
    DELETE_PRODUCT_POST: '/product/delete/:id',
};

module.exports = URL;
const Path = require('path');
const AppRoot = require('app-root-path');

const CATEGORY = {
    CATEGORY_PRODUCTS: 'layouts/category/category-products',
    CREATE_CATEGORY: 'layouts/category/create-category',
};

const OTHER = {
    HOME: 'layouts/home/home'
};

const PRODUCT = {
    BUY_PRODUCT: 'layouts/product/buy-product',
    CREATE_PRODUCT: 'layouts/product/create-product',
    DELETE_PRODUCT: 'layouts/product/delete-product',
    EDIT_PRODUCT: 'layouts/product/edit-product',
};

const AUTHENTICATION = {
    LOGIN: 'layouts/authentication/login',
    REGISTER: 'layouts/authentication/register',
};

const FOLDERS = {
    VIEW_FOLDER: Path.join(AppRoot.path, '/src/resources/views'),
};

const JWT = {
    JWT_SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt'),
};

module.exports = {
    CATEGORY,
    OTHER,
    PRODUCT,
    AUTHENTICATION,
    FOLDERS,
    JWT
};
const DBCoreConstants = {
    DATABASE_NAME: 'ShopStop',
    DATABASE_DOMAIN: 'localhost',
    DATABASE_PORT: '27017'
};

const Models = {
    CATEGORY: 'Category',
    PRODUCT: 'Product',
    ROLE: 'Role',
    USER: 'User',
    JWT: 'JWT'
};

const DBMessageConstants = {
    DATABASE_CONNECTION_SUCCESSFUL: 'Connection established to the database!'
};

let CONNECTION_STRING = `mongodb://${DBCoreConstants.DATABASE_DOMAIN}:${DBCoreConstants.DATABASE_PORT}/${DBCoreConstants.DATABASE_NAME}`;

module.exports = {
    Models,
    DBCoreConstants,
    CONNECTION_STRING,
    DBMessageConstants
};
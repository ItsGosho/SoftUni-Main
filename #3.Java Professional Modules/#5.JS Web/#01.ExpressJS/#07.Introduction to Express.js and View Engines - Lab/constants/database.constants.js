const DatabaseConstants = {
    DATABASE_NAME: 'ShopStop',
    DATABASE_DOMAIN: 'localhost',
    DATABASE_PORT: '27017'
};

let CONNECTION_STRING = `mongodb://${DatabaseConstants.DATABASE_DOMAIN}:${DatabaseConstants.DATABASE_PORT}/${DatabaseConstants.DATABASE_NAME}`;

module.exports = {CONNECTION_STRING};
const DBCoreConstants = {
    DATABASE_NAME: 'interactive-IMDB-db',
    DATABASE_DOMAIN: 'localhost',
    DATABASE_PORT: '27017'
};

const Models = {
    MOVIE: 'Product',
    ROLE: 'Role',
    USER: 'User',
    JWT: 'JWT'
};

const DBMessageConstants = {
    DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been established!'.cyan
};

let CONNECTION_STRING = `mongodb://${DBCoreConstants.DATABASE_DOMAIN}:${DBCoreConstants.DATABASE_PORT}/${DBCoreConstants.DATABASE_NAME}`;

export default {
    Models,
    DBCoreConstants,
    CONNECTION_STRING,
    DBMessageConstants
};
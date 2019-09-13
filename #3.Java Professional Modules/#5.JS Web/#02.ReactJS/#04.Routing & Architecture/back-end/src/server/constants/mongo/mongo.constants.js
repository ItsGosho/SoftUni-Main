const DATABASE_CONFIGURATION_CONSTANTS = {
    DATABASE_NAME: 'interactive-IMDB-db',
    DATABASE_DOMAIN: 'localhost',
    DATABASE_PORT: '27017'
};

const MODEL_NAMES = {
    MOVIE: 'Product',
    ROLE: 'Role',
    USER: 'User',
    JWT: 'JWT'
};


const CONNECTION_STRING = `mongodb://${DATABASE_CONFIGURATION_CONSTANTS.DATABASE_DOMAIN}:${DATABASE_CONFIGURATION_CONSTANTS.DATABASE_PORT}/${DATABASE_CONFIGURATION_CONSTANTS.DATABASE_NAME}`;

export {
    DATABASE_CONFIGURATION_CONSTANTS as MongoDatabaseConfigurationConstants,
    MODEL_NAMES as MongoModelsNamesConstants,
    CONNECTION_STRING as MongoConnectionString
};
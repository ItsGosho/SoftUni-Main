const MONGO_MODEL_LOGGING_CONSTANTS = {
    ORDER: {
        SAVE: '-> '.red + 'Order has been created/updated with title: %s'.cyan
    },
    TOKEN: {
        SAVE: '-> '.red + 'Token has been created/updated for user with id: %s'.cyan,
        DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
    },
    BOOK: {
        SAVE: '-> '.red + 'Book has been create/updated with name: %s'.cyan
    },
    USER: {
        SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
    },
};

const MONGO_CONFIGURATION_LOGGING_CONSTANTS = {
    DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan
};

const OrderLoggingConstants = MONGO_MODEL_LOGGING_CONSTANTS.ORDER;
const TokenLoggingConstants = MONGO_MODEL_LOGGING_CONSTANTS.TOKEN;
const BookLoggingConstants = MONGO_MODEL_LOGGING_CONSTANTS.BOOK;
const UserLoggingConstants = MONGO_MODEL_LOGGING_CONSTANTS.USER;

export {
    OrderLoggingConstants,
    TokenLoggingConstants,
    BookLoggingConstants,
    UserLoggingConstants,
    MONGO_CONFIGURATION_LOGGING_CONSTANTS as DatabaseConfigurationLoggingConstants
};
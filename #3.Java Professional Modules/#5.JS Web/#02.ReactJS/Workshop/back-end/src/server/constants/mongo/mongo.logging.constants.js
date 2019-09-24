const MongoModelLoggingConstants = {
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

const DatabaseConfigurationLoggingConstants = {
    DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan,
    DATABASE_CONNECTION_FAILED: '[Database] Connection has not been established!'.red,
};

const OrderLoggingConstants = MongoModelLoggingConstants.ORDER;
const TokenLoggingConstants = MongoModelLoggingConstants.TOKEN;
const BookLoggingConstants = MongoModelLoggingConstants.BOOK;
const UserLoggingConstants = MongoModelLoggingConstants.USER;

export {
    OrderLoggingConstants,
    TokenLoggingConstants,
    BookLoggingConstants,
    UserLoggingConstants,
    DatabaseConfigurationLoggingConstants
};
const MongoModelLogging = {
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

const DatabaseConfigurationLogging = {
    DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan,
    DATABASE_CONNECTION_FAILED: '[Database] Connection has not been established!'.red,
};

const OrderModelLogging = MongoModelLogging.ORDER;
const TokenModelLogging = MongoModelLogging.TOKEN;
const BookModelLogging = MongoModelLogging.BOOK;
const UserModelLogging = MongoModelLogging.USER;

export {
    OrderModelLogging,
    TokenModelLogging,
    BookModelLogging,
    UserModelLogging,
    DatabaseConfigurationLogging
};
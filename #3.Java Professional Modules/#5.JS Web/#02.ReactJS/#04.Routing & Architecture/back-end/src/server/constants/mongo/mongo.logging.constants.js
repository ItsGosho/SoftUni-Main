const MONGO_MODEL_LOGGING_CONSTANTS = {
    MOVIE: {
        SAVE: '-> '.red + 'Movie has been created/updated with title: %s'.cyan
    },
    TOKEN: {
        SAVE: '-> '.red + 'Token has been created/updated for user with id: %s'.cyan,
        DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
    },
    ROLE: {
        SAVE: '-> '.red + 'Role has been create/updated with name: %s'.cyan
    },
    USER: {
        SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
    },
};

const MONGO_CONFIGURATION_LOGGING_CONSTANTS = {
    DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan
};


const {
    MOVIE: MovieLoggingConstants,
    TOKEN: TokenLoggingConstants,
    ROLE: RoleLoggingConstants,
    USER: UserLoggingConstants
} = MONGO_MODEL_LOGGING_CONSTANTS;

export {
    MovieLoggingConstants,
    TokenLoggingConstants,
    RoleLoggingConstants,
    UserLoggingConstants,
    MONGO_CONFIGURATION_LOGGING_CONSTANTS as DatabaseConfigurationLoggingConstants
};
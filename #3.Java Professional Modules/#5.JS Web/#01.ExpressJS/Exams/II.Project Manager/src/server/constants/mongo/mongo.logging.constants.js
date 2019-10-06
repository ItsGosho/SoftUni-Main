const MongoModelLogging = {
  USER: {
    SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
  },
  JWT: {
    SAVE: '-> '.red + 'JWT has been created/updated for user with id: %s'.cyan,
    DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
  },
}

const DatabaseConfigurationLogging = {
  DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan,
  DATABASE_CONNECTION_FAILED: '[Database] Connection has not been established!'.red,
}

const UserModelLogging = MongoModelLogging.USER
const JWTModelLogging = MongoModelLogging.JWT

export {
  UserModelLogging,
  JWTModelLogging,
  DatabaseConfigurationLogging
}
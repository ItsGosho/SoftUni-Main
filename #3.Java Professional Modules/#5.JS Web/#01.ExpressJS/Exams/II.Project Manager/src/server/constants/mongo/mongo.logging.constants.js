const MongoModelLogging = {
  USER: {
    SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
  },
  JWT: {
    SAVE: '-> '.red + 'JWT has been created/updated for user with id: %s'.cyan,
    DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
  },
  TEAM: {
    SAVE: '-> '.red + 'Team has been created/update with username: %s'.cyan
  },
  PROJECT: {
    SAVE: '-> '.red + 'Project has been created/update with username: %s'.cyan
  },
}

const DatabaseConfigurationLogging = {
  DATABASE_CONNECTION_SUCCESSFUL: '[Database] Connection has been successful!'.cyan,
  DATABASE_CONNECTION_FAILED: '[Database] Connection has not been established!'.red,
}

const UserModelLogging = MongoModelLogging.USER
const JWTModelLogging = MongoModelLogging.JWT
const TeamModelLogging = MongoModelLogging.TEAM
const ProjectModelLogging = MongoModelLogging.PROJECT

export {
  UserModelLogging,
  JWTModelLogging,
  DatabaseConfigurationLogging,
  TeamModelLogging,
  ProjectModelLogging,
}
const Model = {
  USER: {
    USERNAME_REQUIRED: 'Username is required!',
    PASSWORD_REQUIRED: 'Password is required!',
    FIRST_NAME_REQUIRED: 'First Name is required!',
    LAST_NAME_REQUIRED: 'Last Name is required!',
  },

  JWT: {
    TOKEN_REQUIRED: 'JWT is required!'
  },

  TEAM: {
    NAME_REQUIRED: 'Name is required!',
  },

  PROJECT: {
    NAME_REQUIRED: 'Name is required!',
    DESCRIPTION_REQUIRED: 'Description is required!',
    DESCRIPTION_TOO_LONG: 'Description is must be under 50!',
  }
}

const UserModelValidationMessages = Model.USER
const JWTModelValidationMessages = Model.JWT
const TeamModelValidationMessages = Model.TEAM
const ProjectModelValidationMessages = Model.PROJECT

export {
  UserModelValidationMessages,
  JWTModelValidationMessages,
  TeamModelValidationMessages,
  ProjectModelValidationMessages,
}
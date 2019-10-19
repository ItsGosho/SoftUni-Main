const Model = {

  USER: {
    USERNAME_REQUIRED: 'Username is required!',
    PASSWORD_REQUIRED: 'Password is required!',
    ROLE_REQUIRED: 'Role is required!',
    EMAIL_REQUIRED: 'Email is required!',
  },

  CHANNEL: {
    NAME_REQUIRED: 'Name is required!',
    DESCRIPTION_REQUIRED: 'Description is required!',
    TYPE_REQUIRED: 'Type is required!',
  },

  JWT: {
    TOKEN_REQUIRED: 'JWT is required!'
  },
}

const UserModelValidationMessages = Model.USER
const JWTModelValidationMessages = Model.JWT
const ChannelModelValidationMessage = Model.CHANNEL

export {
  UserModelValidationMessages,
  JWTModelValidationMessages,
  ChannelModelValidationMessage,
}
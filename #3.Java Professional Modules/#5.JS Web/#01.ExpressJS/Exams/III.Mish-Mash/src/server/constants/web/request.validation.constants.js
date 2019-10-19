const RequestValidationMessages = {
  USER: {
    CREDENTIALS_NOT_VALID: 'Credentials are invalid!',
    USERNAME_DOESNT_EXIST: 'Username is not present!',
    USERNAME_ALREADY_EXIST: 'Username already exist!',
    EMAIL_ALREADY_EXIST: 'Email already exist!',
    PASSWORDS_DOESNT_MATCH: 'Passwords doesn\'t match!',
  },

  CHANNEL: {
    NAME_ALREADY_EXIST: 'Name already exist!'
  }
}

const RequestValidationRestrictions = {
  USER: {}
}

const UserRequestValidationMessages = RequestValidationMessages.USER
const ChannelRequestValidationMessages = RequestValidationMessages.CHANNEL

const UserRequestValidationRestriction = RequestValidationRestrictions.USER

export {
  UserRequestValidationMessages,

  UserRequestValidationRestriction,
}
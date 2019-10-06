import UserServices from '../../services/user.services'
import { UserRequestValidationMessages } from '../../constants/web/request.validation.constants'

const UserRequestValidators = {

  credentialsValid: (usernameField, passwordField) => {
    return async (data) => {
      let username = data[usernameField]
      let password = data[passwordField]

      let result = await UserServices.isCredentialsValid(username, password)

      if (!result) {
        return Promise.reject(UserRequestValidationMessages.CREDENTIALS_NOT_VALID)
      }
    }
  },

  usernamePresent: (field) => {
    return async (data) => {
      let username = data[field]

      let user = await UserServices.findByUsername(username)

      if (user == null) {
        return Promise.reject(UserRequestValidationMessages.USERNAME_DOESNT_EXIST)
      }
    }
  },

  usernameNotPresent: (field) => {
    return async (data) => {
      let username = data[field]

      let user = await UserServices.findByUsername(username)

      if (user != null) {
        return Promise.reject(UserRequestValidationMessages.USERNAME_ALREADY_EXIST)
      }
    }
  },

  passwordsMustMatch: (field1, field2) => {
    return async (data) => {
      let password = data[field1]
      let confirmPassword = data[field2]

      if (password.length === 0 || password !== confirmPassword) {
        return Promise.reject(UserRequestValidationMessages.PASSWORDS_DOESNT_MATCH)
      }
    }
  },
}

export default UserRequestValidators
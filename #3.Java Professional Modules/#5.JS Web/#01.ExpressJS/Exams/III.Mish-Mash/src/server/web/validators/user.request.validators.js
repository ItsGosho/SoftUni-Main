import UserServices from '../../services/user.services'
import { UserRequestValidationMessages } from '../../constants/web/request.validation.constants'

const UserRequestValidators = {

  credentialsValid: (field1, field2) => {
    let usernameField = field1
    let passwordField = field2

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
    let usernameField = field

    return async (data) => {
      let username = data[usernameField]

      let user = await UserServices.findByUsername(username)

      if (user == null) {
        return Promise.reject(UserRequestValidationMessages.USERNAME_DOESNT_EXIST)
      }
    }
  },

  usernameNotPresent: (field) => {
    let usernameField = field

    return async (data) => {
      let username = data[usernameField]

      let user = await UserServices.findByUsername(username)

      if (user != null) {
        return Promise.reject(UserRequestValidationMessages.USERNAME_ALREADY_EXIST)
      }
    }
  },

  emailNotPresent: (field) => {
    let emailField = field

    return async (data) => {
      let email = data[emailField]

      let user = await UserServices.findByEmail(email)

      if (user != null) {
        return Promise.reject(UserRequestValidationMessages.EMAIL_ALREADY_EXIST)
      }
    }
  },

  passwordsMustMatch: (field1, field2) => {
    let passwordField = field1
    let confirmPasswordField = field2

    return async (data) => {
      let password = data[passwordField]
      let confirmPassword = data[confirmPasswordField]

      if (password.length === 0 || password !== confirmPassword) {
        return Promise.reject(UserRequestValidationMessages.PASSWORDS_DOESNT_MATCH)
      }
    }
  },
}

export default UserRequestValidators
import UserServices from "../../services/user.services";
import {
    UserRequestValidationMessagesConstants,
    UserRequestValidationRestrictionConstants
} from "../../constants/web/request.validation.constants";


const UserRequestValidators = {

    credentialsValid: (usernameField,passwordField) => {
        return async (data) => {
            let username = data[usernameField];
            let password = data[passwordField];

            let result = await UserServices.isCredentialsValid(username,password);


            if (!result) {
                return Promise.reject(UserRequestValidationMessagesConstants.CREDENTIALS_NOT_VALID);
            }
        }
    },

    usernamePresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);


            if (user == null) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_DOESNT_EXIST);
            }
        }
    },

    usernameNotPresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);


            if (user != null) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_ALREADY_EXIST);
            }
        }
    },

    emailNotPresent: (field) => {
        return async (data) => {
            let email = data[field];

            let user = await UserServices.findByEmail(email);


            if (user != null) {
                return Promise.reject(UserRequestValidationMessagesConstants.EMAIL_ALREADY_EXIST);
            }
        }
    },

    usernameLength: (field, min, max) => {
        return async (data) => {
            let username = data[field];

            if (username.length < min) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_TOO_SHORT);
            }

            if (username.length > max) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_TOO_LONG);
            }
        }
    },

    passwordsMustMatch: (field1, field2) => {
        return async (data) => {
            let password = data[field1];
            let confirmPassword = data[field2];

            if (password.length === 0 || password !== confirmPassword) {
                return Promise.reject(UserRequestValidationMessagesConstants.PASSWORDS_DOESNT_MATCH);
            }
        }
    },

    email: (field) => {
        return async (data) => {
            let email = data[field];
            let emailPattern = new RegExp('(?:[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])');

            if (!emailPattern.test(email)) {
                return Promise.reject(UserRequestValidationMessagesConstants.EMAIL_NOT_VALID);
            }
        }
    }
};

export default UserRequestValidators;
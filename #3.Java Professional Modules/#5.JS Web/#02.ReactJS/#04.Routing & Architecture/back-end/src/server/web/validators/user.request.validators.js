import UserServices from "../../services/user.services";
import {
    UserRequestValidationMessagesConstants,
    UserRequestValidationRestrictionConstants
} from "../../constants/web/request.validation.constants";


const UserRequestValidators = {

    usernamePresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);


            if (user == null) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_DOESNT_EXIST);
            }
        }
    },

    usernameLength: (field, min, max) => {
        return async (data) => {
            let username = data[field];
            let minLength = UserRequestValidationRestrictionConstants.USERNAME_MIN_LENGTH;
            let maxLength = UserRequestValidationRestrictionConstants.USERNAME_MAX_LENGTH;

            if (username.length < minLength) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_TOO_SHORT);
            }

            if (username.length > maxLength) {
                return Promise.reject(UserRequestValidationMessagesConstants.USERNAME_TOO_LONG);
            }
        }
    },

    passwordsMustMatch: (field1, field2) => {
        return async (data) => {
            let password = data[field1];
            let confirmPassword = data[field2];

            if (password !== confirmPassword) {
                return Promise.reject(UserRequestValidationMessagesConstants.PASSWORDS_DOESNT_MATCH);
            }
        }
    },
};

export default UserRequestValidators;
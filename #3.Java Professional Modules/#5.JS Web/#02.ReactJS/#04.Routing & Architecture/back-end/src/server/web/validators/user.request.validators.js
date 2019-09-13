import UserServices from "../../services/user.services";
import {UserRequestValidationConstants} from "../../constants/web/request.validation.constants";


const UserRequestValidators = {

    usernamePresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);


            if (user == null) {
                return Promise.reject(UserRequestValidationConstants.USERNAME_DOESNT_EXIST);
            }
        }
    },

    passwordsMustMatch: (field1,field2) => {
        return async (data) => {
            let password = data[field1];
            let confirmPassword = data[field2];

            if (password !== confirmPassword) {
                return Promise.reject(UserRequestValidationConstants.PASSWORDS_DOESNT_MATCH);
            }
        }
    },
};

export default UserRequestValidators;
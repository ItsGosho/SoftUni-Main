import UserServices from "../../services/user.services";
import ValidationMessages from "../../constants/validation.messages.constants";

const UserRequestValidators = {

    usernamePresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);

            if (user == null) {
                return Promise.reject(ValidationMessages.USER.USERNAME_DOESNT_EXIST);
            }
        }
    },

    passwordsMustMatch: (field1,field2) => {
        return async (data) => {
            let password = data[field1];
            let confirmPassword = data[field2];

            if (password !== confirmPassword) {
                return Promise.reject(ValidationMessages.USER.PASSWORDS_DOESNT_MATCH);
            }
        }
    },
};

export default UserRequestValidators;
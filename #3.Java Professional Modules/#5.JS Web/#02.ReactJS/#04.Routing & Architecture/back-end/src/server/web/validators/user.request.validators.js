import UserServices from "../../services/user.services";

const UserRequestValidators = {

    usernamePresent: (field) => {
        return async (data) => {
            let username = data[field];

            let user = await UserServices.findByUsername(username);

            if (user == null) {
                return Promise.reject('Username is not present!');
            }
        }
    },

    passwordsMustMatch: (field1,field2) => {
        return async (data) => {
            let password = data[field1];
            let confirmPassword = data[field2];

            if (password !== confirmPassword) {
                return Promise.reject('Passwords doesn\'t match!');
            }
        }
    },
};

export default UserRequestValidators;
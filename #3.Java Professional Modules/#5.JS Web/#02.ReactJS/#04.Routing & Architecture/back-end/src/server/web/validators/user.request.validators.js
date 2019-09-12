import UserServices from "../../services/user.services";

const UserRequestValidators = {

    usernamePresent: async (data) => {
        let {username} = data;

        let user = await UserServices.findByUsername(username);

        if (user == null) {
            return Promise.reject('Username is not present!');
        }
    },

    passwordsMustMatch: async (data) => {
        let {password, confirmPassword} = data;

        if (password !== confirmPassword) {
            return Promise.reject('Passwords doesn\'t match!');
        }
    },
};

export default UserRequestValidators;
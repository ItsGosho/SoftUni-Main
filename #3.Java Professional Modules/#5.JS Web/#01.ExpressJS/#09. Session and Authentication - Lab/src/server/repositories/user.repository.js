const UserModel = require('../domain/models/user.model');

let save = (user) => {
    return new UserModel(user).save();
};

module.exports = {
    save
};
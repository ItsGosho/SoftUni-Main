const UserModel = require('../domain/models/user.model');

let save = (user) => {
    return new UserModel(user).save();
};

let findByUsername = (username) => {
    return UserModel.findOne({username}).exec();
};

module.exports = {
    save,
    findByUsername
};
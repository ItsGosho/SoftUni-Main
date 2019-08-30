import UserModel from '../domain/models/user.model';


let save = (user) => {
    return new UserModel(user).save();
};

let findByUsername = (username) => {
    return UserModel.findOne({username}).exec();
};

export default {
    save,
    findByUsername
};
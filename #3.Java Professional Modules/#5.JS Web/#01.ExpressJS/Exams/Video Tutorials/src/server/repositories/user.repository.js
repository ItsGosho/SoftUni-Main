import UserModel from '../domain/models/user.model';


const UserRepository = {

    async save(user) {
        return new UserModel(user).save();
    },

    async findByUsername(username) {
        return UserModel.findOne({username}).exec();
    },
    async getCount() {
        return UserModel.count({}).exec();
    },
};

export default UserRepository;
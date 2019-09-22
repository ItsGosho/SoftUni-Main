import UserModel from '../domain/models/user.model';


const UserRepository = {

    async save(user) {
        return new UserModel(user).save();
    },

    async findByUsername(username) {
        return UserModel.findOne({username}).exec();
    },

    async findByEmail(email) {
        return UserModel.findOne({email}).exec();
    },

    async findTotal() {
        return UserModel.count({}).exec();
    }
};

export default UserRepository;
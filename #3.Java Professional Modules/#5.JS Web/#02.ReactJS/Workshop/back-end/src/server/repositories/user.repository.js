import UserModel from '../domain/models/user.model';
import TokenModel from "../domain/models/jwt.token.model";


const UserRepository = {

    async save(data) {
        return new TokenModel(data).save();
    },

    async deleteById(id) {

        return TokenModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return TokenModel.findById(id).exec();
    },

    async findTotal() {
        return TokenModel.count({}).exec();
    },

    /*-----*/

    async findByUsername(username) {
        return UserModel.findOne({username}).exec();
    },

    async findByEmail(email) {
        return UserModel.findOne({email}).exec();
    },
};

export default UserRepository;
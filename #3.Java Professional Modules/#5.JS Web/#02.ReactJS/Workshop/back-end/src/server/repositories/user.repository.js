import UserModel from '../domain/models/user.model';
import BaseRepository from "./base.repository";


class UserRepository extends BaseRepository {

    constructor() {
        super(UserModel);
    }

    async findByUsername(username) {
        return UserModel.findOne({username}).exec();
    }

    async findByEmail(email) {
        return UserModel.findOne({email}).exec();
    }
}

export default UserRepository;
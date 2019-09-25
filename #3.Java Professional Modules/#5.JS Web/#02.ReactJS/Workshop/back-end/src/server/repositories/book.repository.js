import UserModel from '../domain/models/user.model';
import TokenModel from "../domain/models/jwt.token.model";


const BookRepository = {

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
};

export default BookRepository;
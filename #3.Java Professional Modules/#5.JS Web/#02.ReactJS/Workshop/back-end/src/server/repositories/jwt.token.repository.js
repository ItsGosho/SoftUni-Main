import TokenModel from '../domain/models/jwt.token.model';
import BaseRepository from "./base.repository";


class JWTTokenRepository extends BaseRepository{

    constructor() {
        super(TokenModel);
    }

    async findByToken(token) {
        return TokenModel.findOne({token}).exec();
    }

    async findByUserId(userId) {
        return TokenModel.findOne({user: userId}).exec();
    }

    async deleteByUserId(userId) {
        return TokenModel.deleteOne({user: userId}).exec();
    }

    async deleteAllByUserId(userId) {
        return TokenModel.deleteMany({user: userId}).exec();
    }

    async deleteByToken(token) {
        return TokenModel.deleteOne({token}).exec();
    }

}

export default JWTTokenRepository;
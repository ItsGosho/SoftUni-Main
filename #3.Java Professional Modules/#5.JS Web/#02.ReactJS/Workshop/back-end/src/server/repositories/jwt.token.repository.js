import TokenModel from '../domain/models/jwt.token.model';


const JWTTokenRepository =  {

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

    /*----*/

    async findByToken(token) {
        return TokenModel.findOne({token}).exec();
    },

    async findByUserId(userId) {
        return TokenModel.findOne({user: userId}).exec();
    },

    async deleteByUserId(userId) {
        return TokenModel.deleteOne({user: userId}).exec();
    },

    async deleteAllByUserId(userId) {
        return TokenModel.deleteMany({user: userId}).exec();
    },

    async deleteByToken(token) {
        return TokenModel.deleteOne({token}).exec();
    },

};

export default JWTTokenRepository;
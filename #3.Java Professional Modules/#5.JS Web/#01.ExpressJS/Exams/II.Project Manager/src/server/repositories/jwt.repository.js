import JWTModel from '../domain/models/jwt.model';


const JWTRepository =  {

    async save(data) {
        return new JWTModel(data).save();
    },

    async deleteById(id) {
        return JWTModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return JWTModel.findById(id).exec();
    },

    async findTotal() {
        return JWTModel.count({}).exec();
    },

    /*----*/

    async findByToken(token) {
        return JWTModel.findOne({token}).exec();
    },

    async findByUserId(userId) {
        return JWTModel.findOne({user: userId}).exec();
    },

    async deleteByUserId(userId) {
        return JWTModel.deleteOne({user: userId}).exec();
    },

    async deleteAllByUserId(userId) {
        return JWTModel.deleteMany({user: userId}).exec();
    },

    async deleteByToken(token) {
        return JWTModel.deleteOne({token}).exec();
    },

};

export default JWTRepository;
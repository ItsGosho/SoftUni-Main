import JWTRepository from '../repositories/jwt.token.repository';
import JWT from 'jsonwebtoken';
import FileSystem from 'fs';
import ResourceConstants from '../constants/resource.paths.constants';


const JWTPaths = ResourceConstants.JWT;

const JWTTokenServices = {

    async save(token) {
        return JWTRepository.save(token);
    },

    async generateToken(data) {
        const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');
        return JWT.sign(data, secretKey, {expiresIn: '24h'});
    },

    async isValid(token) {
        const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');

        try {
            JWT.verify(token, secretKey);
            return true;
        } catch (e) {
            return false;
        }
    },

    async decode(token) {
        const secretKey = FileSystem.readFileSync(JWTPaths.JWT_SECRET, 'utf8');

        return JWT.decode(token, secretKey);
    },

    async removeAllByUserId(userId) {
        return JWTRepository.deleteAllByUserId(userId);
    },

};

export default JWTTokenServices;
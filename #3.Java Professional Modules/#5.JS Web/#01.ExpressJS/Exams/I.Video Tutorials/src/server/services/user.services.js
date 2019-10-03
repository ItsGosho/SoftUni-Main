import UserRepository from '../repositories/user.repository';
import Roles from '../domain/models/enums/role.enums';
import JWTServices from '../services/jwt.token.services';
import Bcrypt from 'bcrypt-nodejs';


const SaltRounds = 10;

const UserServices = {
    async register(user) {

        let salt = Bcrypt.genSaltSync(SaltRounds);
        let hash = Bcrypt.hashSync(user.password, salt);

        user.password = hash;

        if (await UserRepository.getCount() === 0) {
            user.roles.push(Roles.ADMIN);
            user.roles.push(Roles.USER);
        } else {
            user.roles.push(Roles.USER);
        }

        user = await UserRepository.save(user);
    },

    async isCredentialsValid(username, password) {
        let user = await UserRepository.findByUsername(username);

        if (user !== null) {
            return Bcrypt.compareSync(password, user.password);
        }

        return false;
    },

    async proceedToken(username) {
        let user = await UserRepository.findByUsername(username);

        let tokenData = {
            username: user.username,
        };

        let token = {
            token: await JWTServices.generateToken(tokenData),
            user: user.id
        };

        await JWTServices.removeAllByUserId(user.id);
        return await JWTServices.save(token);
    },

    async findByUsername(username) {
        return UserRepository.findByUsername(username);
    },
};

export default UserServices;
import UserRepository from '../repositories/user.repository';
import JWTServices from './jwt.services';
import Bcrypt from 'bcrypt-nodejs';
import RoleHelper from "../helpers/role.helper";


const SaltRounds = 10;

const UserServices = {

    async register(user) {

        let salt = Bcrypt.genSaltSync(SaltRounds);
        let hash = Bcrypt.hashSync(user.password, salt);

        user.password = hash;
        user.roles = await RoleHelper.getInitialRoles();

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
        //let role = await RoleServices.findRoleByUserId(user.id);

        let tokenData = {
            username: user.username,
            //role: role.name
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

    async findByEmail(email) {
        return UserRepository.findByEmail(email);
    },

    async totalUsers() {
        return UserRepository.findTotal();
    }

};

export default UserServices;
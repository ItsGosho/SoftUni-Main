const UserRepository = require('../repositories/user.repository');
const RoleServices = require('../services/role.services');
const JWTServices = require('../services/jwt.token.services');
const Bcrypt = require('bcrypt-nodejs');
const Mongoose = require('mongoose');
const SaltRounds = 10;

let register = async (user) => {

    let salt = Bcrypt.genSaltSync(SaltRounds);
    let hash = Bcrypt.hashSync(user.password, salt);

    user.password = hash;
    user.role = await RoleServices.getInitialRole();

    user = await UserRepository.save(user);
    RoleServices.addUser(user.role.id, user.id);
};

let isCredentialsValid = async (username, password) => {
    let user = await UserRepository.findByUsername(username);

    if (user !== null) {
        return Bcrypt.compareSync(password, user.password);
    }

    return false;
};

let proceedToken = async (username) => {
    let user = await UserRepository.findByUsername(username);
    let role = await RoleServices.findRoleByUserId(user.id);

    let tokenData = {
        username: user.username,
        role: role.name
    };

    let token = {
        token: JWTServices.generateToken(tokenData),
        user: user.id
    };

    await JWTServices.removeAllByUserId(user.id);
    return JWTServices.save(token);
};

let findByUsername = (username) => {
    return UserRepository.findByUsername(username);
};

module.exports = {
    register,
    isCredentialsValid,
    proceedToken,
    findByUsername
};
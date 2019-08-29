const UserRepository = require('../repositories/user.repository');
const RoleServices = require('../services/role.services');
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

let login = async (username,password) => {
    let user = await UserRepository.findByUsername(username);

    if(user !== null){
        return Bcrypt.compareSync(password, user.password);
    }

    return false;
};

module.exports = {
    register,
    login
};
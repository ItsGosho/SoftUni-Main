let RoleModel = require('../domain/models/role.model');
let Mongoose = require('mongoose');

let findByName = (name) => {
    return RoleModel.findOne({name}).exec();
};

let findById = (id) => {
    return RoleModel.findById(id).exec();
};

let add = async (role) => {
    let existingRole = await findByName(role.name);

    if (existingRole === null) {
        return new RoleModel(role).save();
    } else {
        return existingRole;
    }
};

let removeUserById = async (userId) => {
    try {
        let role = await RoleModel.findOne({'users': {'$in': [`${userId}`]}});
        let users = role.users;

        role.users = users.filter(x => x.id.toString() !== userId);
        role.save();
    } catch (e) {
    }
};

module.exports = {
    findByName,
    findById,
    add,
    removeUserById
};
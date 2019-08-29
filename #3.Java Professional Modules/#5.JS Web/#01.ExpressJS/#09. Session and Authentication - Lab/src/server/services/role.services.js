let RoleRepository = require('../repositories/role.repository');
let Roles = require('../domain/models/enums/role.enums');

let getInitialRole = () => {
    let role = {
        name: Roles.USER
    };

    return RoleRepository.add(role);
};

let addUser = async (roleId, userId) => {
    let role = await RoleRepository.findById(roleId);
    role.users.push(userId);
    role.save();
};

module.exports = {
    getInitialRole,
    addUser
};
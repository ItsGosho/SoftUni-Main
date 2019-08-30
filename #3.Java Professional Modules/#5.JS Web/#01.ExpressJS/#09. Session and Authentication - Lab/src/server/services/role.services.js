import RoleRepository from '../repositories/role.repository';
import Roles from '../domain/models/enums/role.enums';


let getInitialRole = () => {
    let role = {
        name: Roles.USER
    };

    return RoleRepository.add(role);
};

let findRoleByUserId = (id) => {
    return RoleRepository.findByUserId(id);
};

let addUser = async (roleId, userId) => {
    let role = await RoleRepository.findById(roleId);
    role.users.push(userId);
    role.save();
};

export default {
    getInitialRole,
    addUser,
    findRoleByUserId
};
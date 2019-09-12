import RoleRepository from '../repositories/role.repository';
import Roles from '../domain/models/enums/role.enums';


const RoleServices = {

    async getInitialRole() {
        let role = {
            name: Roles.USER
        };
        return RoleRepository.add(role);
    },

    async findRoleByUserId(id) {
        return RoleRepository.findByUserId(id);
    },

    async addUser(roleId, userId) {
        let role = await RoleRepository.findById(roleId);
        role.users.push(userId);
        role.save();
    },

};

export default RoleServices;
import Roles from "../domain/models/enums/role.enums";
import UserServices from "../services/user.services";

const RoleHelper = {

    getHighestRole() {
        let roles = Object.keys(Roles);
        let key = roles[roles.length - 1];

        return Roles[key];
    },

    getAllRoles() {
       return Object.keys(Roles);
    },

    getHighestRoleFrom(roles) {
        let currentHighestRole = '';

        Object.keys(Roles).forEach((key, index)=>{
              let value = Roles[key];

              if(roles.includes(value)){
                  currentHighestRole = value;
              }
        });

        return currentHighestRole;
    },

    getLowestRole() {
        let roles = Object.keys(Roles);
        let key = roles[0];

        return Roles[key];
    },

    async getInitialRoles() {
        let totalUsers = await UserServices.totalUsers();

        if(totalUsers === 0){
            return RoleHelper.getAllRoles();
        }

        let result = [];
        result.push(RoleHelper.getLowestRole());

        return result;
    }

};

export default RoleHelper;
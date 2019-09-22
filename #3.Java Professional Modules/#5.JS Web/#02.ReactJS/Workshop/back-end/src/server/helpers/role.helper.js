import ROLES from "../domain/models/enums/role.enums";
import UserServices from "../services/user.services";

const RoleHelper = {

    getHighestRole() {
        let roles = Object.keys(ROLES);
        let key = roles[roles.length - 1];

        return ROLES[key];
    },

    getAllRoles() {
       return Object.keys(ROLES);
    },

    getHighestRoleFrom(roles) {
        let currentHighestRole = '';

        Object.keys(ROLES).forEach((key,index)=>{
              let value = ROLES[key];

              if(roles.includes(value)){
                  currentHighestRole = value;
              }
        });

        return currentHighestRole;
    },

    getLowestRole() {
        let roles = Object.keys(ROLES);
        let key = roles[0];

        return ROLES[key];
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
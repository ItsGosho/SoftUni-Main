import UserRoles from "../../domain/models/enums/role.enums";

const RoleHelper = {
    getRole(user) {
        if (user.roles.filter(x => x === UserRoles.ADMIN)[0] !== undefined) {
            return UserRoles.ADMIN;
        } else if (user.roles.filter(x => x === UserRoles.USER)[0] !== undefined) {
            return UserRoles.USER;
        }
    }
};

export default RoleHelper;
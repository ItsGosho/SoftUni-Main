import RoleModel from '../domain/models/role.model';


const RoleRepository = {

    async findByName(name) {
        return RoleModel.findOne({name}).exec();
    },

    async findById(id) {
        return RoleModel.findById(id).exec();
    },

    async add(role) {
        let existingRole = await this.findByName(role.name);

        if (existingRole === null) {
            return new RoleModel(role).save();
        } else {
            return existingRole;
        }
    },

    async removeUserById(userId) {
        try {
            let role = await RoleModel.findOne({'users': {'$in': [`${userId}`]}});
            let users = role.users;

            role.users = users.filter(x => x.id.toString() !== userId);
            role.save();
        } catch (e) {
        }
    },

    async findByUserId(userId) {
        return RoleModel.findOne({'users': {'$in': [`${userId}`]}});
    },

};

export default RoleRepository;
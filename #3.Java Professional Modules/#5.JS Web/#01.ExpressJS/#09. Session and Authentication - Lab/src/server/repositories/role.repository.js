let RoleModel = require('../domain/models/role.model');

let findByName = (name) => {
    return RoleModel.findOne({name}).exec();
};

let add = (role) => {
    return new RoleModel(role).save();
};

module.exports = {
    findByName,
    add
};

/*
* TODO:
*  1.Remove user from specific role
*  2.Dont add role if it exists already
*
* */
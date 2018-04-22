const Sequelize = require('sequelize');

module.exports = function (sequelize) {
    let Cat = sequelize.define("Cat",{
        name: Sequelize.TEXT,
        nickname: Sequelize.TEXT,
        price: Sequelize.DOUBLE,

    },{
        timestamps:false
    });

    return Cat;
};
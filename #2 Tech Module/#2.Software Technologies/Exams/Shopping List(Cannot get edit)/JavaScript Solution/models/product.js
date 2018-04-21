const Sequelize = require('sequelize');

module.exports = function(sequelize){
    let Product = sequelize.define('Product',{
        priority:{
            type: Sequelize.INTEGER,
            allowNull: false,
        },
        name:{
            type: Sequelize.TEXT,
            allowNull: false,
        },
        quantity:{
            type: Sequelize.INTEGER,
            allowNull: false,
        },
        status:{
            type: Sequelize.TEXT,
            allowNull: false,
        }
    },{
        timestamps:false
    });

    return Product;
};
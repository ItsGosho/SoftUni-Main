const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const config = (configuration) => {
    mongoose.connect(configuration.connectionString);

    let database = mongoose.connection;

    database.once('open', (error) => {
        if (error) {
            console.log(error);
            return;
        }
        console.log('Connection established to the database!');
    });

    require('../models/product');
};

module.exports = config;

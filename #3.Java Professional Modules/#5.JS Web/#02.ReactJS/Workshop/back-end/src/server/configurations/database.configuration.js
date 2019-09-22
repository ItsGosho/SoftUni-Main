import mongoose from 'mongoose';
import {DatabaseConfigurationLoggingConstants} from "../constants/mongo/mongo.logging.constants";


mongoose.Promise = global.Promise;

const onOpen = (error) => {
    if (error) {
        console.log(error);
        return;
    }

    console.log(DatabaseConfigurationLoggingConstants.DATABASE_CONNECTION_SUCCESSFUL);
};

export default (configuration) => {
    mongoose.connect(configuration.connectionString);

    let database = mongoose.connection;

    database.once('open', onOpen);
};

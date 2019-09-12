import mongoose from 'mongoose';
import DatabaseConstants from '../constants/mongoose.constants';


mongoose.Promise = global.Promise;

const onOpen = (error) => {
    if (error) {
        console.log(error);
        return;
    }
    console.log(DatabaseConstants.DBMessageConstants.DATABASE_CONNECTION_SUCCESSFUL);
};

export default (configuration) => {
    mongoose.connect(configuration.connectionString);

    let database = mongoose.connection;

    database.once('open', onOpen);
};

import mongoose from 'mongoose';
import {DatabaseConfigurationLoggingConstants} from "../constants/mongo/mongo.logging.constants";
import Properties from "./properties";


mongoose.Promise = global.Promise;

export default () => {
    mongoose.connect(Properties.database.url);

    let database = mongoose.connection;

    database.once('open', () => {
        console.log(DatabaseConfigurationLoggingConstants.DATABASE_CONNECTION_SUCCESSFUL)
    });
    
    database.once('error', ()=>{
        console.log(DatabaseConfigurationLoggingConstants.DATABASE_CONNECTION_FAILED)
    });
};

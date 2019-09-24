import Mongoose from 'mongoose';
import {DatabaseConfigurationLoggingConstants} from "../constants/mongo/mongo.logging.constants";
import Properties from "./properties";


//mongoose.Promise = global.Promise;

export default () => {
    Mongoose.connect(Properties.database.url);

    const database = Mongoose.connection;

    database.once('open', () => {
        console.log(DatabaseConfigurationLoggingConstants.DATABASE_CONNECTION_SUCCESSFUL)
    });

    database.once('error', ()=>{
        console.log(DatabaseConfigurationLoggingConstants.DATABASE_CONNECTION_FAILED)
    });
};

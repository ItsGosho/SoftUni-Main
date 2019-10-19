import Mongoose from 'mongoose';
import Properties from './properties';
import {DatabaseConfigurationLogging} from '../constants/mongo/mongo.logging.constants';


export default () => {
    Mongoose.connect(Properties.database.url);

    const database = Mongoose.connection;

    database.once('open', () => {
        console.log(DatabaseConfigurationLogging.DATABASE_CONNECTION_SUCCESSFUL)
    });

    database.once('error', ()=>{
        console.log(DatabaseConfigurationLogging.DATABASE_CONNECTION_FAILED)
    });
};

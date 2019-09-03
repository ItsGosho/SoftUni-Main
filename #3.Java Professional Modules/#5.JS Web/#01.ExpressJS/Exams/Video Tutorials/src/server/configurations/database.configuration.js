import mongoose from 'mongoose';
import DatabaseConstants from '../constants/mongoose.constants';


mongoose.Promise = global.Promise;

const onOpen = (error) => {
    if (error) {
        console.log(error);
        return;
    }
    console.log(DatabaseConstants.MESSAGES.DATABASE_CONNECTION_SUCCESSFUL);
};

export default (connectionUrl) => {
    mongoose.connect(connectionUrl);

    let database = mongoose.connection;

    database.once('open', onOpen);

    require('../domain/models/user.model');
    require('../domain/models/jwt.token.model');
    require('../domain/models/lecture.model');
    require('../domain/models/course.model');
};

import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './src/server/configurations/express.configuration';
import DatabaseConfiguration from './src/server/configurations/database.configuration';
import {MongoConnectionString} from "./src/server/constants/mongo/mongo.constants";
import {ServerPort} from "./src/server/constants/server/server.constants";
import {ServerLoggingConstants} from "./src/server/constants/server/server.logging.constants";


const App = Express();

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: MongoConnectionString});

App.listen(ServerPort, () => {
    console.log(ServerLoggingConstants.SERVER_STARTED);
});

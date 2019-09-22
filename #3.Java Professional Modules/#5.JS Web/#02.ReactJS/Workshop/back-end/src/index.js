import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import {ServerLoggingConstants} from "./server/constants/server/server.logging.constants";
import {ServerConfigurationConstants} from "./server/constants/server/server.configuration.constants";
import {MongoDatabaseConfigurationConstants} from "./server/constants/mongo/mongo.configuration.constants";


const App = Express();

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: MongoDatabaseConfigurationConstants.CONNECTION_STRING});

App.listen(ServerConfigurationConstants.PORT, () => {
    console.log(ServerLoggingConstants.SERVER_STARTED);
});

import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import Properties from "./server/configurations/properties";
import {ServerLogging} from "./server/constants/server/server.logging.constants";

let app = Express();

ExpressConfiguration(app);
DatabaseConfiguration();

app.listen(Properties.server.port, () => {
    console.log(ServerLogging.SERVER_STARTED);
});


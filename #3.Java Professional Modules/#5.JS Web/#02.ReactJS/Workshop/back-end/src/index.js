import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import {ServerLoggingConstants} from "./server/constants/server/server.logging.constants";
import Properties from "./server/configurations/properties";

let app = Express();

ExpressConfiguration(app);
DatabaseConfiguration({connectionString: Properties.database.url});

app.listen(Properties.server.port, () => {
    console.log(ServerLoggingConstants.SERVER_STARTED);
});


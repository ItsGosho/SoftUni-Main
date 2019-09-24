import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import Properties from "./server/configurations/properties";
import {ServerLogging} from "./server/constants/server/server.logging.constants";
import UserRequestValidators from "./server/web/validators/user.request.validators";

let app = Express();

ExpressConfiguration(app);
DatabaseConfiguration();

app.listen(Properties.server.port, () => {
    console.log(ServerLogging.SERVER_STARTED);
});

let func = UserRequestValidators.usernameNotPresent('username');
console.log(UserRequestValidators.usernameNotPresent('username'));


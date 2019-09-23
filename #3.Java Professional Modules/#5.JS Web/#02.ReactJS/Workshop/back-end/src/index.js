import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import {ServerLoggingConstants} from "./server/constants/server/server.logging.constants";
import RoleHelper from "./server/helpers/role.helper";
import UserServices from "./server/services/user.services";
import Properties from "./server/configurations/properties";
import Commander from 'commander';

Commander.option('--environment <type>', 'Current environment to use!');

let env = Commander.parse(process.argv).environment || 'dev';
let properties = Properties[env];

const App = Express();

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: properties.database.url});

App.listen(properties.server.port, () => {
    console.log(ServerLoggingConstants.SERVER_STARTED);
});
const App = require('express')();

const ServerConstants = require('./constants/server.constants');
const DatabaseConstants = require('./constants/database.constants');
const ExpressConfiguration = require('./configurations/express.configuration');
const DatabaseConfiguration = require('./configurations/database.configuration');

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: DatabaseConstants.CONNECTION_STRING});

App.listen(ServerConstants.PORT, () => {
    console.log(ServerConstants.SERVER_STARTED);
});


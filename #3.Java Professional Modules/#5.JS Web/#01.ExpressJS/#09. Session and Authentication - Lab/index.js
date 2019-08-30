const App = require('express')();

const ServerConstants = require('./src/server/constants/server.constants');
const DatabaseConstants = require('./src/server/constants/mongoose.constants');
const ExpressConfiguration = require('./src/server/configurations/express.configuration');
const DatabaseConfiguration = require('./src/server/configurations/database.configuration');

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: DatabaseConstants.CONNECTION_STRING});

App.listen(ServerConstants.PORT, () => {
    console.log(ServerConstants.SERVER_STARTED);
});
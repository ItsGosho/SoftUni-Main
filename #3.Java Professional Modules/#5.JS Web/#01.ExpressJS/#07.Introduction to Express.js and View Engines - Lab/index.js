const App = require('express')();
const ServerConstants = require('./constants/server.constants');
const ExpressConfiguration = require('./configurations/express.configuration');

ExpressConfiguration(App);
App.listen(ServerConstants.PORT, () => {
    console.log(ServerConstants.SERVER_STARTED);
});

/*
const Database = require('./configurations/database.configuration');
const Configuration = require('./configurations/configuration');
Database(Configuration.development);
*/

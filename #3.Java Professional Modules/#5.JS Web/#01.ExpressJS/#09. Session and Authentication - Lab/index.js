const App = require('express')();

const ServerConstants = require('./src/server/constants/server.constants');
const DatabaseConstants = require('./src/server/constants/database.constants');
const ExpressConfiguration = require('./src/server/configurations/express.configuration');
const DatabaseConfiguration = require('./src/server/configurations/database.configuration');

ExpressConfiguration(App);
DatabaseConfiguration({connectionString: DatabaseConstants.CONNECTION_STRING});

App.listen(ServerConstants.PORT, () => {
    console.log(ServerConstants.SERVER_STARTED);
});

const RoleRepository = require('./src/server/repositories/role.repository');
const Roles = require('./src/server/domain/models/enums/role.enums');
RoleRepository.add({name: Roles.ADMIN});
//test


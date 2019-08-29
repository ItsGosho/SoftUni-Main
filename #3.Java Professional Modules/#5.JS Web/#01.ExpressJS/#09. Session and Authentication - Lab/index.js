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

test();

async function test() {
    const RoleRepository = require('./src/server/repositories/role.repository');
    const Roles = require('./src/server/domain/models/enums/role.enums');
    //let savedRole = await RoleRepository.add({name: Roles.ADMIN});
    /*savedRole.users.push('randomUserId');
    savedRole.save();*/

    //let role = await RoleRepository.findById('5d67a45b4684a32c88abb28a');

    //await RoleRepository.removeUserById('randomUserId',role._id);
}

//test2323


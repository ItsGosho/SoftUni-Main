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
    let JWTTokenServices = require('./src/server/services/jwt.token.services');
    //let token = JWTTokenServices.generateToken({username: 'itsgosho',role: 'Admin'});
    console.log(JWTTokenServices.decode('eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Iml0c2dvc2hvIiwicm9sZSI6IkFkbWluIiwiaWF0IjoxNTY3MDgzMzExLCJleHAiOjE1NjcxNjk3MTF9.1kEyiLFiKa8ctr2uWSATsfAae8pLhvnu6bDzQrStv-k'));
}

//test2323


import Express from 'express';
import ServerConstants from './src/server/constants/server.constants';
import ExpressConfiguration from './src/server/configurations/express.configuration';
import DatabaseConfiguration from './src/server/configurations/database.configuration';
import DatabaseConstants from './src/server/constants/mongoose.constants';


const App = Express();

ExpressConfiguration(App);
DatabaseConfiguration(DatabaseConstants.CONNECTION_STRING());

App.listen(ServerConstants.PORT, () => {
    console.log(ServerConstants.SERVER_STARTED());
});

import Express from 'express';
import Colors from 'colors';
import ExpressConfiguration from './server/configurations/express.configuration';
import DatabaseConfiguration from './server/configurations/database.configuration';
import Properties from "./server/configurations/properties";
import {ServerLogging} from "./server/constants/server/server.logging.constants";
import Kura from "./kura";
import Djoni from "./djoni";
let inversify = require('inversify');
require('reflect-metadata');

let app = Express();

ExpressConfiguration(app);
DatabaseConfiguration();

app.listen(Properties.server.port, () => {
    console.log(ServerLogging.SERVER_STARTED);
});

const DEPENDENCIES = {
    Repository: 'Repository',
    Services: 'Services'
};

inversify.decorate(inversify.injectable(),Djoni);
inversify.decorate(inversify.injectable(),Kura);
inversify.decorate(inversify.inject(DEPENDENCIES.Repository),Kura,0);

let container = new inversify.Container();

container.bind(DEPENDENCIES.Repository).to(Djoni);
container.bind(DEPENDENCIES.Services).to(Kura);

let service = container.get(DEPENDENCIES.Services);

service.test();

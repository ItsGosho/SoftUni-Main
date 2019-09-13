import BodyParser from 'body-parser';
import Morgan from 'morgan';
import CookieParser from 'cookie-parser';
import MiddlewaresConfiguration from './middlewares.configuration';
import Cors from 'cors';

import AuthenticationController from '../web/controllers/authentication.controller';
import TestController from '../web/controllers/test.controller';


export default (app) => {
    app.use(Morgan('dev'));

    app.use(BodyParser.urlencoded({extended: true}));
    app.use(BodyParser.json());
    app.use(CookieParser());
    app.use(Cors({
        origin: 'http://localhost:8000',
        credentials: true
    }));

    app.use(MiddlewaresConfiguration);

    app.use(AuthenticationController);
    app.use(TestController);
};
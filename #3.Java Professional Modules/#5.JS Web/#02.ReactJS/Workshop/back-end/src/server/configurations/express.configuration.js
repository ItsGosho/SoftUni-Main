import BodyParser from 'body-parser';
import Morgan from 'morgan';
import CookieParser from 'cookie-parser';
import MiddlewaresConfiguration from './middlewares.configuration';
import Cors from 'cors';
import AuthenticationController from '../web/controllers/authentication.controller';
import BookController from '../web/controllers/book.controller';
import OrderController from '../web/controllers/order.controller';
import StatisticsController from '../web/controllers/statistics.controller';
import Properties from "./properties";


export default (app) => {
    app.use(Morgan(Properties.morgan.environment));

    app.use(BodyParser.urlencoded({extended: Properties.bodyParser.extended}));
    app.use(BodyParser.json());
    app.use(CookieParser());
    app.use(Cors({
        origin: Properties.cors.origins[0],
        credentials: Properties.cors.credentials
    }));

    app.use(MiddlewaresConfiguration);

    app.use(AuthenticationController);
    app.use(BookController);
    app.use(OrderController);
    app.use(StatisticsController);
};
import BodyParser from 'body-parser';
import HandleBars from 'express-handlebars';
import MultiPart from 'connect-multiparty';
import ResourcePaths from '../constants/resource.paths.constants';
import Morgan from 'morgan';
import CookieParser from 'cookie-parser';
import Session from 'express-session';
import MiddlewaresConfiguration from '../configurations/middlewares.configuration';

import HomeController from '../web/controllers/home.controller';
import CategoryController from '../web/controllers/category.controller';
import ProductController from '../web/controllers/product.controller';
import AuthenticationController from '../web/controllers/authentication.controller';


export default (app) => {
    app.use(Morgan('dev'));

    app.use(MultiPart());
    app.use(BodyParser.urlencoded({extended: true}));
    app.use(CookieParser());
    app.use(Session({secret: 'JoretoSecret', saveUninitialized: false, resave: false}));

    app.use(MiddlewaresConfiguration);

    app.use(HomeController);
    app.use(CategoryController);
    app.use(ProductController);
    app.use(AuthenticationController);

    app.use('/static', require('express').static('src/resources/public'));

    app.set('views', ResourcePaths.FOLDERS.VIEW_FOLDER);

    app.engine('.hbs', HandleBars({
        defaultLayout: 'index',
        extname: '.hbs',
        layoutsDir: `${ResourcePaths.FOLDERS.VIEW_FOLDER}\\layouts`,
        partialsDir: `${ResourcePaths.FOLDERS.VIEW_FOLDER}\\partials`,
    }));

    app.set('view engine', '.hbs');

};
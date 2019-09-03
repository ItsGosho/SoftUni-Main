import BodyParser from 'body-parser';
import HandleBars from 'express-handlebars';
import MultiPart from 'connect-multiparty';
import ResourcePaths from '../constants/resource.paths.constants';
import Morgan from 'morgan';
import CookieParser from 'cookie-parser';
import Session from 'express-session';
import MiddlewaresConfiguration from '../configurations/middlewares.configuration';

import HandlebarsHelpers from '../helpers/handlebars.helpers';

import HomeController from '../web/controllers/home.controller';
import AuthenticationController from '../web/controllers/authentication.controller';
import CourseController from '../web/controllers/course.controller';
import LectureController from '../web/controllers/lecture.controller';


export default (app) => {
    app.use(Morgan('dev'));

    app.use(MultiPart());
    app.use(BodyParser.urlencoded({extended: true}));
    app.use(CookieParser());
    app.use(Session({secret: 'JoretoSecret', saveUninitialized: false, resave: false}));

    app.use(MiddlewaresConfiguration);

    app.use(HomeController);
    app.use(AuthenticationController);
    app.use(CourseController);
    app.use(LectureController);

    app.use('/static', require('express').static('src/resources/public'));

    app.set('views', ResourcePaths.FOLDERS.VIEW_FOLDER);

    app.engine('.hbs', HandleBars({
        defaultLayout: 'index',
        extname: '.hbs',
        helpers: HandlebarsHelpers,
        layoutsDir: `${ResourcePaths.FOLDERS.VIEW_FOLDER}\\layouts`,
        partialsDir: `${ResourcePaths.FOLDERS.VIEW_FOLDER}\\partials`,
    }));

    app.set('view engine', '.hbs');

};
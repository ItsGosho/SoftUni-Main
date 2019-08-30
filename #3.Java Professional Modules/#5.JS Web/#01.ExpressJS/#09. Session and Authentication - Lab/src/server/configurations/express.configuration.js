const BodyParser = require('body-parser');
const HandleBars = require('express-handlebars');
const MultiPart = require('connect-multiparty');
const ResourcePaths = require('../constants/resource.paths.constants');
const Morgan = require('morgan');
const Colors = require('colors');
const CookieParser = require('cookie-parser');
const Session = require('express-session');
const MiddlewaresConfiguration = require('../configurations/middlewares.configuration');

module.exports = (app) => {
    app.use(Morgan('dev'));

    app.use(MultiPart());
    app.use(BodyParser.urlencoded({extended: true}));
    app.use(CookieParser());
    app.use(Session({secret: 'JoretoSecret', saveUninitialized: false, resave: false}));

    app.use(MiddlewaresConfiguration);

    app.use(require('../web/controllers/home.controller'));
    app.use(require('../web/controllers/category.controller'));
    app.use(require('../web/controllers/product.controller'));
    app.use(require('../web/controllers/authentication.controller'));

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
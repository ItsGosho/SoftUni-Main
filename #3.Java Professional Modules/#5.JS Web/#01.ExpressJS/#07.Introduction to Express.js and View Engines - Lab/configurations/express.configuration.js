const BodyParser = require('body-parser');
const HandleBars = require('express-handlebars');
const MultiPart = require('connect-multiparty');
const FolderPaths = require('../constants/folder.path.constants');

module.exports = (app) => {
    app.use(MultiPart());
    app.use(BodyParser.urlencoded({extended: true}));

    app.use(require('../controllers/home.controller'));
    app.use(require('../controllers/category.controller'));
    app.use(require('../controllers/product.controller'));

    app.use('/static', require('express').static('public'));

    app.set('views', FolderPaths.VIEW_FOLDER);

    app.engine('.hbs', HandleBars({
        defaultLayout: '',
        extname: '.hbs',
        layoutsDir: `${FolderPaths.VIEW_FOLDER}\\layouts`,
        partialsDir: `${FolderPaths.VIEW_FOLDER}\\partials`,
    }));

    app.set('view engine', '.hbs');

};
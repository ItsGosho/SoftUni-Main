const BodyParser = require('body-parser');
const HandleBars = require('express-handlebars');
const FolderPaths = require('../constants/folder.path.constants');
const MultiPart = require('connect-multiparty');

module.exports = (app) => {
    app.use(MultiPart());
    app.use(BodyParser.urlencoded({extended: true}));

    app.use(require('../controllers/home.controller'));
    app.use(require('../controllers/category.controller'));
    app.use(require('../controllers/product.controller'));

    app.use('/static', require('express').static('public'));

    app.engine('.hbs', HandleBars({
        extname: '.hbs',
        defaultLayout: '',
        layoutsDir: '',
    }));

    app.set('view engine', '.hbs')
};
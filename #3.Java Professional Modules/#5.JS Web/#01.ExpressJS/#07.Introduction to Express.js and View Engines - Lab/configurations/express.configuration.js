const BodyParser = require('body-parser');

module.exports = (app) => {
    app.use(BodyParser.urlencoded({extend: true}));

    app.use(require('../controllers/home.controller'));
    app.use(require('../controllers/category.controller'));
    app.use(require('../controllers/product.controller'));
};
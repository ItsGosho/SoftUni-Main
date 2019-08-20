const App = require('express')();
const Port = 8000;
const BodyParser = require('body-parser');

App.use(BodyParser.urlencoded({extend: true}));

App.use(require('./controllers/home.controller'));
App.use(require('./controllers/category.controller'));
App.use(require('./controllers/product.controller'));

App.listen(Port, () => {
    console.log(`Server started on ${Port}`);
});

/*
const Database = require('./configurations/database.configuration');
const Configuration = require('./configurations/configuration');
Database(Configuration.development);
*/

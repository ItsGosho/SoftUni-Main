let app = require('express')();
let port = 8000;

app.listen(port,()=>{
    console.log(`Server started on ${port}`);
});


/*
const http = require('http');
const handlers = require('./handlers/handlers');
const Database = require('./configurations/database.configuration');
const Configuration = require('./configurations/configuration');
Database(Configuration.development);

let port = 8000;

let server = http.createServer((request, response) => {

    for (let handler of handlers) {
        if (!handler(request, response)) {
            break;
        }
    }

});
*/

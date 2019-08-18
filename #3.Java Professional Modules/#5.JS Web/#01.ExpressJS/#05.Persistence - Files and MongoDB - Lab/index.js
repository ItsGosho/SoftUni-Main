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

server.listen(port);


console.log(`Server started on ${port}`);

/*
let product = {
  name: 'salam',
  description: 'mn hubav',
  price: 3.00,
  image: 'https://nqma.bg',
  isBought: false
};

Product.create(product).then(()=>{
    console.log('Product saved!');
});
*/

console.log();


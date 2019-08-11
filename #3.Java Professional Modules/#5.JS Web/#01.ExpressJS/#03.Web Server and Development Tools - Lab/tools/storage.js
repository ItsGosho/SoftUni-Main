const FileSystem = require('fs');
const Path = require('path');
const dbPath = Path.join(__dirname,'../content/database.json');

let idCounter = 1;
function getProducts() {
    if(!FileSystem.existsSync(dbPath)){
        FileSystem.writeFileSync(dbPath,'[]');
        return [];
    }

    let json = FileSystem.readFileSync(dbPath).toString();
    return JSON.parse(json);
}

function saveProducts(products) {
    let json = FileSystem.readFileSync(dbPath).toString();
    FileSystem.writeFileSync(dbPath,JSON.stringify(products));
}

module.exports.getProducts = getProducts;

module.exports.add = (product) => {
    let products = getProducts();
    product.id = idCounter++;
    products.push(product);
    saveProducts(products);
}

module.exports.findByName  = (name) =>{
    return getProducts().filter(p => p.name.toLowerCase().includes(name));
}

let products = [];
let count = 1;


let getAll = () => {
    return products;
};

let add = (product) => {
    product.id = count;
    products.push(product);
    count++;
};

let findByName = (name) => {

    let result = null;
    for (let product of products) {
        if(product.name === name){
            result = product;
            return;
        }
    }

    return result;
};

module.exports = {getAll,add,findByName};
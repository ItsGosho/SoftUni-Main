const Repository = require('../repositories/product.repository');

let save = Repository.save;
let findAll = Repository.findAll;

module.exports = {save, findAll};
const Repository = require('../repositories/product.repository');

let save = Repository.save;

module.exports = {save};
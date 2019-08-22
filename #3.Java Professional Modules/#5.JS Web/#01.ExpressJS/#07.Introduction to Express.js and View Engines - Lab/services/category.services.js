const Repository = require('../repositories/category.repository');

let save = Repository.save;
let findAll = Repository.findAll;

module.exports = {save,findAll};
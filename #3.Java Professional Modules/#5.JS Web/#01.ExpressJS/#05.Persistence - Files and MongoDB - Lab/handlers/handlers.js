const home = require('./home.handler');
const resource = require('./resource.handler');
const productCreate = require('./product-create.handler');
const categoryCreate = require('./category-create.handler');

module.exports = [home,resource,productCreate,categoryCreate];
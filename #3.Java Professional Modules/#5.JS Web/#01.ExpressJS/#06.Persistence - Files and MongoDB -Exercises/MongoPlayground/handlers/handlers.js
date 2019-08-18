const homeHandler= require('./home.handler');
const addImageHandler = require('./add_image.handler');
const addTagHandler = require('./tag.handler');
const searchHandler = require('./search.handler');
const staticFileHandler = require('./static.handler');

module.exports = [homeHandler,addTagHandler,searchHandler,addImageHandler,staticFileHandler];
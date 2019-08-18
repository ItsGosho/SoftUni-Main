const FileSystem = require('fs');
const TemplatePaths = require('../constants/templates.path.constants');

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.OutgoingMessage} response
 * */
let viewAddMeme = (request, response) => {
    FileSystem.readFile(TemplatePaths.ADD_MEME, ((err, data) => {
         let html = data.toString();

         response.write(html);
         response.end();
    }))
};

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.OutgoingMessage} response
 * */
let viewAll = (request, response) => {

    console.log('View all has been invoked');
};

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.OutgoingMessage} response
 * */
let addMeme = (request, response) => {
    console.log('Add meme has been invoked');
};

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.OutgoingMessage} response
 * */
let getDetails = (request, response) => {
    console.log('Get details has been invoked');
};


module.exports = {viewAddMeme, viewAll, addMeme, getDetails};
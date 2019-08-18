const FileSystem = require('fs');
const TemplatePaths = require('../constants/templates.path.constants');
const FolderPaths = require('../constants/folder.path.constants');
const MemeServices = require('../services/meme.services');
const MultiParty = require('multiparty');
const ShortID = require('shortid');


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
    FileSystem.readFile(TemplatePaths.VIEW_ALL, ((err, data) => {
        let html = data.toString();

        response.write(html);
        response.end();
    }))
};

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.ServerResponse} response
 * */
let addMeme = (request, response) => {
    let form = new MultiParty.Form;
    let meme = {};

    form.parse(request, function (err, fields, files) {

        let img = files.meme[0];
        let extension = img.originalFilename.substr(img.originalFilename.lastIndexOf('.') + 1);

        meme.title = fields.memeTitle[0];
        meme.description = fields.memeDescription[0];
        meme.privacy = fields.status !== undefined ? fields.status[0] : 'off';
        meme.publishDate = Date.now();
        meme.imageSrc = `${FolderPaths.MEME_STORAGE}/${ShortID.generate()}.${extension}`;

        FileSystem.writeFileSync(meme.imageSrc,FileSystem.readFileSync(img.path));

        MemeServices.addMeme(meme);

        response.writeHead(301, {
            'Location': '/'
        });
        response.end();
    });
};

/**
 * @param {module:http.IncomingMessage} request
 * @param {module:http.OutgoingMessage} response
 * */
let getDetails = (request, response) => {
    console.log('Get details has been invoked');
};


module.exports = {viewAddMeme, viewAll, addMeme, getDetails};
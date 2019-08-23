const Repository = require('../repositories/product.repository');
const DropboxServices = require('../services/dropbox.services');

const ShortId = require('shortid');
const FileSystem = require('fs');

//${ShortID.generate()}
let save = (product, callback) => {
    return Repository.save(product, (e, savedProduct) => {
        callback(e, savedProduct);
    });
};
let findAll = Repository.findAll;

let uploadImage = (image, callback) => {
    let file = FileSystem.readFileSync(image.path);
    let extension = image.name.substring(image.name.lastIndexOf('.'));
    let path = `${ShortId.generate()}${extension}`;
    DropboxServices.uploadFile(file, path);

    callback(path);
};

module.exports = {save, findAll, uploadImage};
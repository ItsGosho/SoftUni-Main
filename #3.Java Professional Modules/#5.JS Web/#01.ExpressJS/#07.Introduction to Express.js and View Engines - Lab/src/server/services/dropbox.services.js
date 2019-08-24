let Fetch = require('isomorphic-fetch');
let FileSystem = require('fs');
let Dropbox = require('../singletons/dropbox');

let uploadFile = (file, dropboxFileName) => {
    Dropbox.filesUpload({path: '/' + dropboxFileName, contents: file})
        .then(function (response) {
            console.log(`File has been uploaded to Dropbox with path ${dropboxFileName}`);
        })
        .catch(function (error) {
            console.error('There was a error:');
            console.error(error);
        });
};

let downloadFile = (dropboxFilePath) => {
    return Dropbox.filesDownload({path: '/' + dropboxFilePath});
};

let deleteFile = (dropboxFilePath) => {
    Dropbox.filesDelete({path: '/' + dropboxFilePath})
        .then(function (response) {
            console.log(`File with path [/${dropboxFilePath}] has been deleted!`);
        }).catch(function (error) {
        console.log(`File with path [/${dropboxFilePath}] was NOT been deleted!!`);
    });
};

module.exports = {uploadFile, downloadFile,deleteFile};
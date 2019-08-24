let Fetch = require('isomorphic-fetch');
let FileSystem = require('fs');
let Dropbox = require('../singletons/dropbox');

let uploadFile = (file, dropboxFileName) => {
   return Dropbox.filesUpload({path: '/' + dropboxFileName, contents: file});
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
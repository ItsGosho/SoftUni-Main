let fetch = require('isomorphic-fetch');
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

/*
* @param dropboxFilePath ex: /proba2.png
* */
let downloadFile = (dropboxFilePath) => {
    return Dropbox.filesDownload({path: '/' + dropboxFilePath});
};

module.exports = {uploadFile, downloadFile};
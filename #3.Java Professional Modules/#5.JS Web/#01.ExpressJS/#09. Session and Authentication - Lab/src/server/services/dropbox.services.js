const Fetch = require('isomorphic-fetch');
const FileSystem = require('fs');
const Dropbox = require('../singletons/dropbox');
const Logging = require('../constants/logging.constants').DROPBOX;
const Format = require('sprintf-js').sprintf;

let uploadFile = async (file, dropboxFileName) => {
    let result = Dropbox.filesUpload({path: '/' + dropboxFileName, contents: file});

    result.then((response) => {
        console.log(Format(Logging.UPLOAD_SUCCESSFUL, `'/' + ${dropboxFileName}`));
    }).catch((reason => {
        console.log(Format(Logging.UPLOAD_FAILED, `'/' + ${dropboxFileName}`));
    }));

    return result;
};

let downloadFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDownload({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(Format(Logging.DOWNLOAD_SUCCESSFUL, dropboxFilePath));
    }).catch((reason => {
        console.log(Format(Logging.DOWNLOAD_FAILED, dropboxFilePath));
    }));

    return result;
};

let deleteFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDelete({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(Format(Logging.DELETE_SUCCESSFUL, dropboxFilePath));
    }).catch((error) => {
        console.log(Format(Logging.DELETE_FAILED, dropboxFilePath));
    });

    return result;
};

module.exports = {
    uploadFile,
    downloadFile,
    deleteFile
};
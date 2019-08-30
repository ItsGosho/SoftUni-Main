let Fetch = require('isomorphic-fetch');
let FileSystem = require('fs');
let Dropbox = require('../singletons/dropbox');

let uploadFile = async (file, dropboxFileName) => {
    let result = Dropbox.filesUpload({path: '/' + dropboxFileName, contents: file});

    result.then((response) => {
        console.log(`File with path [/${dropboxFilePath}] has been downloaded!`.cyan);
    }).catch((reason => {
        console.log(`File with path [/${dropboxFilePath}] has NOT been downloaded!`.red);
    }));

    return result;
};

let downloadFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDownload({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(`File with path [/${dropboxFilePath}] has been downloaded!`.cyan);
    }).catch((reason => {
        console.log(`File with path [/${dropboxFilePath}] has NOT been downloaded!`.red);
    }));

    return result;
};

let deleteFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDelete({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(`File with path [/${dropboxFilePath}] has been deleted!`.cyan);
    }).catch((error) => {
        console.log(`File with path [/${dropboxFilePath}] was NOT been deleted!!`.red);
    });

    return result;
};

module.exports = {
    uploadFile,
    downloadFile,
    deleteFile
};
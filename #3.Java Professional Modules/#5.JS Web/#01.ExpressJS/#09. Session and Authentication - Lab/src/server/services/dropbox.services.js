import Dropbox from '../singletons/dropbox';
import Logging from '../constants/logging.constants';
import Format from 'sprintf-js';

const ParseString = Format.sprintf;

let uploadFile = async (file, dropboxFileName) => {
    let result = Dropbox.filesUpload({path: '/' + dropboxFileName, contents: file});

    result.then((response) => {
        console.log(ParseString(Logging.DROPBOX.UPLOAD_SUCCESSFUL, `'/' + ${dropboxFileName}`));
    }).catch((reason => {
        console.log(ParseString(Logging.DROPBOX.UPLOAD_FAILED, `'/' + ${dropboxFileName}`));
    }));

    return result;
};

let downloadFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDownload({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(ParseString(Logging.DROPBOX.DOWNLOAD_SUCCESSFUL, dropboxFilePath));
    }).catch((reason => {
        console.log(ParseString(Logging.DROPBOX.DOWNLOAD_FAILED, dropboxFilePath));
    }));

    return result;
};

let deleteFile = async (dropboxFilePath) => {
    let result = Dropbox.filesDelete({path: '/' + dropboxFilePath});

    result.then((response) => {
        console.log(ParseString(Logging.DROPBOX.DELETE_SUCCESSFUL, dropboxFilePath));
    }).catch((error) => {
        console.log(ParseString(Logging.DROPBOX.DELETE_FAILED, dropboxFilePath));
    });

    return result;
};

export default {
    uploadFile,
    downloadFile,
    deleteFile
};
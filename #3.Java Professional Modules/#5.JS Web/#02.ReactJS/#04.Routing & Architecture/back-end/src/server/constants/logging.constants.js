import 'colors';

const DROPBOX = {
    UPLOAD_SUCCESSFUL: 'File with path [/%s] has been uploaded!'.cyan,
    UPLOAD_FAILED: 'File with path [/%s] has NOT been uploaded!'.red,

    DOWNLOAD_SUCCESSFUL: 'File with path [/%s] has been downloaded!'.cyan,
    DOWNLOAD_FAILED: 'File with path [/%s] has NOT been downloaded!'.red,

    DELETE_SUCCESSFUL: 'File with path [/%s] has been deleted!'.cyan,
    DELETE_FAILED: 'File with path [/%s] has NOT been delete!'.red,
};

const MONGOOSE = {
    MODEL: {
        MOVIE: {
            SAVE: '-> '.red + 'Movie has been created/updated with title: %s'.cyan
        },
        JWT_TOKEN: {
            SAVE: '-> '.red + 'Token has been created/updated for user with id: %s'.cyan,
            DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
        },
        ROLE: {
            SAVE: '-> '.red + 'Role has been create/updated with name: %s'.cyan
        },
        USER: {
            SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
        },
    }
};

export default {
    DROPBOX,
    MONGOOSE
};
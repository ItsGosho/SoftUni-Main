const Path = require('path');
const AppRoot = require('app-root-path');

const Paths = {
    HOME: Path.join(AppRoot.path, 'views/home.html'),

    ADD_MEME: Path.join(AppRoot.path, '/views/addMeme.html'),
    DETAILS: Path.join(AppRoot.path, '/views/details.html'),
    STATUS: Path.join(AppRoot.path, '/views/status.html'),
    VIEW_ALL: Path.join(AppRoot.path, '/views/viewAll.html'),
};

module.exports = Paths;
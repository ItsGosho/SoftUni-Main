const Path = require('path');
const AppRoot = require('app-root-path');

const Paths = {
    VIEW_FOLDER: Path.join(AppRoot.path, 'views'),
};

module.exports = Paths;
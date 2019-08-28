const Path = require('path');
const AppRoot = require('app-root-path');

const Paths = {
    VIEW_FOLDER: Path.join(AppRoot.path, '/src/resources/views'),
};

module.exports = Paths;
const Path = require('path');
const AppRoot = require('app-root-path');

const Paths = {
    MEME_STORAGE: Path.join(AppRoot.path, 'public/memeStorage'),
};

module.exports = Paths;
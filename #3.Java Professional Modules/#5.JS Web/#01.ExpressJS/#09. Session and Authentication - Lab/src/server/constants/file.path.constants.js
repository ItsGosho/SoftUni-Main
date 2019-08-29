const Path = require('path');
const AppRoot = require('app-root-path');

const Paths = {
    JWT_SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt'),
};

module.exports = Paths;
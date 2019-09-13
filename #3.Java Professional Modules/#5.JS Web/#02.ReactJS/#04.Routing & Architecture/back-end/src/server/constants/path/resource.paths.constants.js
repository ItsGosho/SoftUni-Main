import Path from 'path';
import AppRoot from 'app-root-path';

const JWT = {
    SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt')
};

export {
    JWT as JWTResourcePaths
};
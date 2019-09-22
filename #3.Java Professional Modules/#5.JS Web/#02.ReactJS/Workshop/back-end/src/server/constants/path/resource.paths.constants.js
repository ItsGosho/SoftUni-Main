import Path from 'path';
import AppRoot from 'app-root-path';

const ResourcePaths = {
    JWT: {
        SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt')
    }
};

const JWTResourcePaths = ResourcePaths.JWT;

export {
    JWTResourcePaths
};
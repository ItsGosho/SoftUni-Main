import Path from 'path';
import AppRoot from 'app-root-path';

const JWT = {
    JWT_SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt'),
};

export default {
    JWT
};
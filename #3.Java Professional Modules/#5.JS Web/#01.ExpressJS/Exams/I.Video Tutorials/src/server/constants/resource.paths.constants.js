import Path from 'path';
import AppRoot from 'app-root-path';

const ResourceConstants = {

    OTHER: {
        HOME: 'layouts/home/home',
    },

    AUTHENTICATION: {
        LOGIN: 'layouts/authentication/login',
        REGISTER: 'layouts/authentication/register',
    },

    COURSE: {
        CREATE: 'layouts/course/course-create',
        EDIT: 'layouts/course/course-edit',
        ENROLLED_IN: 'layouts/course/details-enrolled-in',
        NOT_ENROLLED_IN: 'layouts/course/details-not-enrolled-in',
    },


    LECTURE: {
        PANEL: 'layouts/panels/lecture-panel',
    },


    VIDEO: {
        PLAY: 'layouts/video/play-video'
    },

    FOLDERS: {
        VIEW_FOLDER: Path.join(AppRoot.path, '/src/resources/views'),
    },

    JWT: {
        JWT_SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt'),
    },

};

export default ResourceConstants;
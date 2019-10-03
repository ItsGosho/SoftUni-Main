const RoutingURLs = {
    BASE: {
        HOME: '/',
    },

    USER: {
        LOGIN: '/auth/login',
        REGISTER: '/auth/register',
        LOGOUT: '/auth/logout',
    },

    COURSE: {
        CREATE: '/course/create',
        EDIT: '/course/edit/:id',
        DETAILS: '/course/details/:id',
        ENROLL: '/course/enroll/:id',
    },

    LECTURE: {
        ADD: '/lecture/course/add/:id',
        PANEL: '/lecture/panel/course/:id',
        DELETE: '/lecture/:id/delete',
        PLAY: '/lecture/:id/play'
    }
};

export default RoutingURLs;
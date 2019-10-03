import 'colors';

const LoggingConstants = {
    MONGOOSE: {
        MODEL: {
            JWT_TOKEN: {
                SAVE: '-> '.red + 'Token has been created/updated for user with id: %s'.cyan,
                DELETE_MANY: '-> '.red + '%s tokens have been deleted!'.cyan
            },
            USER: {
                SAVE: '-> '.red + 'User has been created/update with username: %s'.cyan
            },
            COURSE: {
                SAVE: '-> '.red + 'Course has been created/update with title: %s'.cyan
            },
            LECTURE: {
                SAVE: '-> '.red + 'Lecture has been created/update with title: %s'.cyan
            },
        }
    },
};

export default LoggingConstants;
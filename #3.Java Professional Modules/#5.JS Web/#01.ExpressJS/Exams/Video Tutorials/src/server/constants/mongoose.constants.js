const MongooseConstants = {
    PROPERTIES: {
        DATABASE_NAME: 'VideoTutorials',
        DATABASE_DOMAIN: 'localhost',
        DATABASE_PORT: '27017'
    },

    MODELS: {
        USER: 'User',
        JWT: 'JWT',
        COURSE: 'Course',
        LECTURE: 'Lecture'
    },

    MESSAGES: {
        DATABASE_CONNECTION_SUCCESSFUL: 'Connection established to the database!'
    },

    CONNECTION_STRING() {
        return `mongodb://${this.PROPERTIES.DATABASE_DOMAIN}:${this.PROPERTIES.DATABASE_PORT}/${this.PROPERTIES.DATABASE_NAME}`;
    },
};

export default MongooseConstants;
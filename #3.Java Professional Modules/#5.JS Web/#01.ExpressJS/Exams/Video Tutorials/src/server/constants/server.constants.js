const ServerConstants = {
    PORT: 8000,
    SERVER_STARTED() {
        return `Server started on ${this.PORT}`;
    }
};


export default ServerConstants;
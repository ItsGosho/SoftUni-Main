const Properties = {
    dev: {
        database: {
           url: 'mongodb://localhost:27017/BookLibrary'
        },
        cors: {
            origins: [
                'http://localhost:8000'
            ]
        },
        server: {
            port: 9881
        }
    }
};

export default Properties;
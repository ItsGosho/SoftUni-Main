import Commander from 'commander';

const props = {
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

Commander.option('--environment <type>', 'Current environment to use!');

let env = Commander.parse(process.argv).environment || 'dev';
let Properties = props[env];

export default Properties;
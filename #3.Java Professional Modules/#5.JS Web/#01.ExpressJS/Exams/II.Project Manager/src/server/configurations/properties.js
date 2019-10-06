import Commander from 'commander';

const props = {
    dev: {
        database: {
            url: 'mongodb://localhost:27017/TEST'
        },
        bodyParser: {
            extended: true
        },
        morgan: {
            environment: 'dev'
        },
        server: {
            port: 8000
        },
        jwt: {
            cookieName: 'jwt',
            maxAge: 86400000, //24h
            httpOnly: true
        }
    }
};

Commander.option('--environment <type>', 'Current environment to use!');

let env = Commander.parse(process.argv).environment || 'dev';
let Properties = props[env];

export default Properties;
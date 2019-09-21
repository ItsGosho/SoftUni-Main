const path = require('path')

let rootPath = path.normalize(path.join(__dirname, '/../'))

module.exports = {
  development: {
    rootPath: rootPath,
    db: 'mongodb://localhost:27017/BookLibrary',
    port: 9000
  },
  staging: {
  },
  production: {
    port: process.env.PORT
  }
}

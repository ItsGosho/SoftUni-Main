let FileSystem = require('fs');

function getHTMLAsString(path) {
    path = `${__rootDirectory}/${path}`;
    let result = FileSystem.readFileSync(path).toString();
    return result;
}

module.exports = {getHTMLAsString};
let fetch = require('isomorphic-fetch');
let FileSystem = require('fs');
let Dropbox = require('./singletons/dropbox');

let file = FileSystem.readFileSync('C:\\Users\\Gosho\\Desktop\\test_kartina.png');
Dropbox.filesUpload({path: '/' + 'proba.png', contents: file})
    .then(function (response) {
        console.log('File uploaded!');
    })
    .catch(function (error) {
        console.error('There was a error:');
        console.error(error);
    });

let uploadFile = () => {

};
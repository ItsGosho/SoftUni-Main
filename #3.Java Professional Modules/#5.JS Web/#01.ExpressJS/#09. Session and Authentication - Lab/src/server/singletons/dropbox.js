const ACCESS_TOKEN = 'k-aFCKNYmaAAAAAAAAAAWPI477TB18AoO8Zwyf8MKG0HNN0j_g2EnF178dU8GliX';

let Dropbox = require('dropbox').Dropbox;
Dropbox = new Dropbox({accessToken: ACCESS_TOKEN});

module.exports = Dropbox;
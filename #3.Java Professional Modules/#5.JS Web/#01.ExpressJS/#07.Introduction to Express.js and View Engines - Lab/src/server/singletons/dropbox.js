let Constants = require('../constants/dropbox.constants');
let Dropbox = require('dropbox').Dropbox;
Dropbox = new Dropbox({accessToken: Constants.ACCESS_TOKEN});

module.exports = Dropbox;
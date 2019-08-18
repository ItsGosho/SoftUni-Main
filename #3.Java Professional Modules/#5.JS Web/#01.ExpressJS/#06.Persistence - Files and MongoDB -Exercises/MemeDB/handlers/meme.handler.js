let Dispatchers = require('../dispatchers/dispatchers');
let RequestMethods = require('../constants/request.methods.constants');
let URLs = require('../constants/url.constants');

/**
 * @param {module:http.IncomingMessage} req
 * @param {module:http.OutgoingMessage} res
 * @param {String} req.pathname
 * */
module.exports = (req, res) => {
    if (req.pathname === URLs.MEME.VIEW_ALL && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.viewAll(req, res)
    } else if (req.pathname === URLs.MEME.ADD && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.viewAddMeme(req, res);
    } else if (req.pathname === URLs.MEME.ADD && req.method === RequestMethods.POST) {
        Dispatchers.memeDispatcher.addMeme(req, res)
    } else if (req.pathname === URLs.MEME.DETAILS && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.getDetails(req, res)
    } else if (req.pathname.startsWith('public/memeStorage') && req.method === RequestMethods.GET) {
        console.log('Meme storage wut?')
    } else {
        return true
    }
};

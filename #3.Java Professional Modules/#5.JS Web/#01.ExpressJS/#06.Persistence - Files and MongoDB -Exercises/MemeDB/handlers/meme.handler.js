let Dispatchers = require('../dispatchers/dispatchers');
let RequestMethods = require('../constants/request.methods.constants');

/**
 * @param {module:http.IncomingMessage} req
 * @param {module:http.OutgoingMessage} res
 * @param {String} req.pathname
 * */
module.exports = (req, res) => {
    if (req.pathname === '/viewAllMemes' && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.viewAll(req, res)
    } else if (req.pathname === '/addMeme' && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.viewAddMeme(req, res);
    } else if (req.pathname === '/addMeme' && req.method === RequestMethods.POST) {
        Dispatchers.memeDispatcher.addMeme(req, res)
    } else if (req.pathname.startsWith('/getDetails') && req.method === RequestMethods.GET) {
        Dispatchers.memeDispatcher.getDetails(req, res)
    } else if (req.pathname.startsWith('public/memeStorage') && req.method === RequestMethods.GET) {
        console.log('Meme storage wut?')
    } else {
        return true
    }
};

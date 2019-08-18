let MemeModel = require('../models/Meme');

let addMeme = (meme) => {
    MemeModel.create(meme, (err, meme) => {
        if (err) {
            return;
        }
        console.log('Meme created successful!');
    });
};


module.exports = {addMeme};
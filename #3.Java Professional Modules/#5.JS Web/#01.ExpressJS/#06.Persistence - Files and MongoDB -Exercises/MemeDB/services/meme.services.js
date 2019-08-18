/**
 * @type {Model|Query} MemeModel
 * */
let MemeModel = require('../models/Meme');


let add = (meme) => {

    new MemeModel(meme).save(function (err) {
        if (err) {
            return;
        }
        console.log('Meme created successful!');
    })
};

let findAll = (callback) => {
   MemeModel.find().then((memes)=>{
       callback(memes);
   })
};

module.exports = {add, findAll};
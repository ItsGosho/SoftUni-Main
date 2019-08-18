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
    MemeModel.find().then((memes) => {
        callback(memes);
    })
};

let findById = (id, callback) => {
    MemeModel.findById(id).exec(callback);
};

module.exports = {add, findAll,findById};
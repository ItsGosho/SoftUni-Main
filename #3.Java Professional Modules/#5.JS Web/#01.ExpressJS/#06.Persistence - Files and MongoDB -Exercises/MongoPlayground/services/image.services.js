/**
 * @type {Model|Query} MemeModel
 * */
let ImageSchema = require('../models/ImageSchema');

let add = (image, callback) => {
    ImageSchema.create(image, (error, image) => {
        if(error){
            return;
        }
        callback(image);
    });

};

module.exports = {add};
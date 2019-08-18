/**
 * @type {Model|Query} MemeModel
 * */
let TagSchema = require('../models/TagSchema');

let add = (tag) => {
    new TagSchema(tag).save((error) => {
        if(error){
            return;
        }
        console.log('Tag Saved!');
    })
};

module.exports = {add};
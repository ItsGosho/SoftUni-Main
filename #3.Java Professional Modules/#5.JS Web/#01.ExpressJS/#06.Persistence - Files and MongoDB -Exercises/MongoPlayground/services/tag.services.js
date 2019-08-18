/**
 * @type {Model|Query} MemeModel
 * */
let TagSchema = require('../models/TagSchema');

let add = (tag) => {
    new TagSchema(tag).save((error) => {
        if (error) {
            return;
        }
        console.log('Tag Saved!');
    })
};

let findById = (id, callback) => {
    TagSchema.findById(id).exec(callback);
};

module.exports = {add, findById};
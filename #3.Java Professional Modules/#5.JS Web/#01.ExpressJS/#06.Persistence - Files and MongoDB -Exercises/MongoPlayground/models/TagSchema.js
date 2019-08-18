const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const tagSchema = new Schema({
    name: {
        type: Schema.Types.String,
        require: true,
        lowercase: true
    },
    images: [{
        type: Schema.Types.ObjectID,
        ref: 'Image'
    }],
    creationDate: {
        type: Schema.Types.Date,
        require: true
    }
});

let Tag = mongoose.model('Tag',tagSchema);

module.exports = Tag;
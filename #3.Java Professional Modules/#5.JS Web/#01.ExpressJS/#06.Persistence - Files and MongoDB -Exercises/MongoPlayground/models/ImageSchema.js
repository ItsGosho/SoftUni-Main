const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const imageSchema = new Schema({
    title: {
        type: Schema.Types.String,
        require: true
    },
    description: {
        type: Schema.Types.String,
        require: true
    },
    url: {
        type: Schema.Types.String,
        require: true
    },
    tags: [{
        type: Schema.Types.ObjectID,
        ref: 'Tag'
    }],
    creationDate: {
        type: Schema.Types.Date,
        require: true
    }
});

let Image = mongoose.model('Image', imageSchema);

module.exports = Image;
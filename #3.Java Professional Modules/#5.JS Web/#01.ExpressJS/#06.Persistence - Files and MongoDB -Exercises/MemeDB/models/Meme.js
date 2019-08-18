const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const memeSchema = new Schema({
    title: {
        type: Schema.Types.String,
        require: true
    },
    imageSrc: {
        type: Schema.Types.String,
        require: true
    },
    description: {
        type: Schema.Types.String,
        require: true
    },
    privacy: {
        type: Schema.Types.String,
        require: true
    },
    publishDate: {
        type: Schema.Types.Date,
        require: true
    }
});

let Meme = mongoose.model('Meme',memeSchema);

module.exports = Meme;
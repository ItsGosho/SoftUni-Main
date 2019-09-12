import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;
const LogModel = LoggingConstants.MONGOOSE.MODEL.MOVIE;
const ParseString = Format.sprintf;

const movieModel = new Schema({
    title: {
        type: String,
        required: true
    },
    storyLine: {
        type: String,
        required: true
    },
    trailerUrl: {
        type: String,
        required: true
    },
    poster: {
        type: String,
        required: true
    }
});

movieModel.post('save', function (movie) {
    console.log(ParseString(LogModel.SAVE, movie.title));
});

let MovieModel = Mongoose.model(Models.MOVIE, movieModel);

export default MovieModel;
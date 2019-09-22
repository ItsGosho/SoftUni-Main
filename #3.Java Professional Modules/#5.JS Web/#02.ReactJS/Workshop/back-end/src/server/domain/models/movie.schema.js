import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {MovieLoggingConstants} from "../../constants/mongo/mongo.logging.constants";
import {ModelNameConstants} from "../../constants/mongo/mongo.models.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const movieModel = new Schema({
    title: {
        type: Type.String,
        required: true
    },
    storyLine: {
        type: Type.String,
        required: true
    },
    trailerUrl: {
        type: Type.String,
        required: true
    },
    poster: {
        type: Type.String,
        required: true
    }
});

movieModel.post('save', function (movie) {
    console.log(ParseString(MovieLoggingConstants.SAVE, movie.title));
});

let MovieModel = Mongoose.model(ModelNameConstants.MOVIE, movieModel);

export default MovieModel;
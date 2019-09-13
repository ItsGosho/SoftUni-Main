import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {MongoModelLoggingMessageConstants} from "../../constants/mongo/mongo.logging.constants";
import {MongoModelsNamesConstants} from "../../constants/mongo/mongo.constants";

const LoggingMessages = MongoModelLoggingMessageConstants.MOVIE;


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
    console.log(ParseString(LoggingMessages.SAVE, movie.title));
});

let MovieModel = Mongoose.model(MongoModelsNamesConstants.MOVIE, movieModel);

export default MovieModel;
import Mongoose from 'mongoose';
import Format from "sprintf-js";
import {BookModelValidationMessages} from "../../constants/mongo/mongo.validation.constants";
import {BookModelLogging} from "../../constants/mongo/mongo.logging.constants";
import ModelNames from "../../constants/mongo/mongo.models.constants";

const Schema = Mongoose.Schema;
const Type = Schema.Types;
const ParseString = Format.sprintf;

const model = new Schema({
    title: {
        type: Type.String,
        required: [true, BookModelValidationMessages.TITLE_REQUIRED],
        unique: [true, BookModelValidationMessages.TITLE_UNIQUE],
        trim: true,
    },
    genres: [
        {
            type: Type.String
        }
    ],
    author: {
        type: Type.String,
        required: [true, BookModelValidationMessages.AUTHOR_REQUIRED]
    },
    description: {
        type: Type.String
    },
    price: {
        type: Type.Number,
        required: [true, BookModelValidationMessages.PRICE_REQUIRED]
    },
    image: {
        type: Type.String,
        required: [true, BookModelValidationMessages.IMAGE_REQUIRED]
    },
    likes: [
        {
            type: Type.String
        }
    ],
    reviews: []

});

model.post('save', function (book) {
    console.log(ParseString(BookModelLogging.SAVE, book.title));
});

let BookModel = Mongoose.model(ModelNames.BOOK, model);

export default BookModel;
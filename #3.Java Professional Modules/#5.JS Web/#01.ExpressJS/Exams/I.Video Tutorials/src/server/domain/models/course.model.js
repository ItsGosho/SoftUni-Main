import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const Models = MongooseConstants.MODELS;
const LogModel = LoggingConstants.MONGOOSE.MODEL.COURSE;
const ParseString = Format.sprintf;

const courseModel = new Schema({
    title: {
        type: Type.String,
        required: [true, 'Title is required!'],
        unique: true,
        trim: true,
    },
    description: {
        type: Type.String,
        required: [true, 'Description is required!'],
        maxLength: [50, 'Description length must be below 50!'],
        trim: true,
    },
    imageURL: {
        type: Type.String,
        required: [true, 'Image URL is required!'],
        trim: true,
    },
    isPublic: {
        type: Type.Boolean,
        default: true
    },
    lectures: [{
        type: Type.ObjectID,
        ref: Models.LECTURE
    }]
});

courseModel.post('save', function (course) {
    console.log(ParseString(LogModel.SAVE, course.title));
});


let CourseModel = Mongoose.model(Models.COURSE, courseModel);

export default CourseModel;
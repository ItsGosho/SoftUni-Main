import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';
import LoggingConstants from '../../constants/logging.constants';
import Format from "sprintf-js";


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const Models = MongooseConstants.MODELS;
const LogModel = LoggingConstants.MONGOOSE.MODEL.LECTURE;
const ParseString = Format.sprintf;

const lectureModel = new Schema({
    title: {
        type: Type.String,
        required: [true, 'Title is required!'],
        trim: true,
    },
    videoURL: {
        type: Type.String,
        required: [true, 'Video URL is required!'],
        trim: true,
    },
    course: {
        type: Type.ObjectID,
        ref: Models.COURSE
    }
});

lectureModel.post('save', function (lecture) {
    console.log(ParseString(LogModel.SAVE, lecture.title));
});


let LectureModel = Mongoose.model(Models.LECTURE, lectureModel);

export default LectureModel;
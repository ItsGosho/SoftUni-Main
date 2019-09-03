import LectureModel from '../domain/models/lecture.model';


const LectureRepository = {

    async save(lecture) {
        return new LectureModel(lecture).save();
    },

    async findById(id) {
        return LectureModel.findById(id).exec();
    },

    async deleteById(id) {
        return LectureModel.deleteOne({'_id': id}).exec();
    },

    async findAll() {
        return LectureModel.find({}).exec();
    },

    async findAllByCourseId(courseId) {
        return LectureModel.find({'course':courseId}).exec();
    }

};

export default LectureRepository;
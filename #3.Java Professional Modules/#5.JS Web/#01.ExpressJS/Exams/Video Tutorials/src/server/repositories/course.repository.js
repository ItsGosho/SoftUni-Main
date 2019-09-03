import CourseModel from '../domain/models/course.model';


const CourseRepository = {

    async save(token) {
        return new CourseModel(token).save();
    },

    async findById(id) {
        return CourseModel.findById(id).exec();
    },

    async deleteById(id) {
        return CourseModel.deleteOne({'_id': id}).exec();
    },

    async findAll() {
        return CourseModel.find({}).exec();
    }

};

export default CourseRepository;
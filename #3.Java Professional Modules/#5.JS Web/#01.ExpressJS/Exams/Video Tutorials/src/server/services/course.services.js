import CourseRepository from "../repositories/course.repository";

const CourseServices = {

    async save(course) {
        return CourseRepository.save(course);
    },

    async findById(id) {
        return CourseRepository.findById(id);
    },

    async findAll() {
        return CourseRepository.findAll();
    }

};

export default CourseServices;
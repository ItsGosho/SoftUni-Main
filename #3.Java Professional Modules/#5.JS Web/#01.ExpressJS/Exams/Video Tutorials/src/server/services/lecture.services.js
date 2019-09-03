import LectureRepository from "../repositories/lecture.repository";

const LectureServices = {

    async save(lecture) {
        return LectureRepository.save(lecture);
    },

    async findById(id) {
        return LectureRepository.findById(id);
    },

    async findAll() {
        return LectureRepository.findAll();
    },

    async findAllByCourseId(id) {
        return LectureRepository.findAllByCourseId(id);
    },

    async removeById(id) {
        return LectureRepository.deleteById(id);
    }
};

export default LectureServices;
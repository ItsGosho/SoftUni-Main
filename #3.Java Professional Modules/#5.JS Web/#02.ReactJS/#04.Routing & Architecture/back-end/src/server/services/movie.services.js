import MovieRepository from "../repositories/movie.repository";

const MovieServices = {
    async save(movie) {
        return MovieRepository.save(movie);
    },

    async findById(id) {
        return MovieRepository.findById(id);
    },

    async findAll() {
        return MovieRepository.findAll();
    },

    async deleteById(id) {
        return MovieRepository.deleteById(id);
    },
};

export default MovieServices;
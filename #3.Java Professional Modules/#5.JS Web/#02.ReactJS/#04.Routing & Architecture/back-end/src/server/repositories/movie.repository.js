import MovieModel from "../domain/models/movie.schema";


const MovieRepository = {

    async save(movie) {
        return new MovieModel(movie).save();
    },

    async findById(id) {
        return MovieModel.findById(id).exec();
    },

    async findAll() {
        return MovieModel.find().exec();
    },

    async deleteById(id) {
        return MovieModel.deleteOne({_id: id}).exec();
    },

};

export default MovieRepository;
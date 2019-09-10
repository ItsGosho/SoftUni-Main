import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";

const MovieServices = {

    async findAll() {
        return RequestHelper.requestJson(RestURLs.MOVIE.ALL);
    },

    async create(movie) {
        let mockedToken = 'test';
        return RequestHelper.postDataAuth(RestURLs.MOVIE.CREATE, movie, mockedToken);
    }

};

export default MovieServices;
import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";
import NotificationHelper from "../helpers/notification.helper";
import CookieHelper from "../helpers/cookie.helper";

const MovieServices = {

    async findAll() {
        let result = await RequestHelper.requestJson(RestURLs.MOVIE.ALL);
        return result.data;
    },

    async create(movie) {
        let result = await RequestHelper.postData(RestURLs.MOVIE.CREATE,movie);
        console.log(result);
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return false;
        }

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
        return true;
    }

};

export default MovieServices;
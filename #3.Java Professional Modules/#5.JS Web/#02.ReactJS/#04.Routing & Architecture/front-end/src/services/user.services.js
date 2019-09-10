import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";

const UserServices = {

    async login(data) {
        return RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, data)
    },

    async register(data) {
        return RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, data)
    }
};

export default UserServices;
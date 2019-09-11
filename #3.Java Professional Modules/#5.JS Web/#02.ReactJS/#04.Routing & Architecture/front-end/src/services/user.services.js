import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";
import CookieHelper from "../helpers/cookie.helper";

const UserServices = {

    /*TODO: check if the logic is successful!*/
    async login(data) {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, data);

        CookieHelper.pushCookie('isAdmin',result.isAdmin,24);
        CookieHelper.pushCookie('username',result.username,24);

        return result;
    },

    async register(data) {
        return RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, data);
    }
};

export default UserServices;
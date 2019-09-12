import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";
import CookieHelper from "../helpers/cookie.helper";
import NotificationHelper from "../helpers/notification.helper";

const UserServices = {

    /*TODO: refactor it for SOLID principle*/
    async login(data) {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, data);

        if (result.error) {
            NotificationHelper.showErrorNotification(result.error.message);
            return null;
        }

        let success = result.success;
        let {isAdmin, username} = success.data;

        CookieHelper.pushCookie('isAdmin', result.isAdmin, 24);
        CookieHelper.pushCookie('username', result.username, 24);

        NotificationHelper.showSuccessNotification(success.message);

        return result;
    },

    async register(data) {
        return RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, data);
    }
};

export default UserServices;
import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";
import NotificationHelper from "../helpers/notification.helper";
import CookieHelper from "../helpers/cookie.helper";

const UserServices = {

    async login(data) {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, data);
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return false;
        }

        let {username, role} = result.data;

        CookieHelper.pushCookie('username', username, 24);
        CookieHelper.pushCookie('role', role, 24);

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
        return true;
    },


    async register(data) {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, data);
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return false;
        }

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
        return true;
    },

    async logout() {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGOUT);
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return false;
        }

        CookieHelper.removeCookie('username');
        CookieHelper.removeCookie('role');

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
        return true;
    }
};

export default UserServices;
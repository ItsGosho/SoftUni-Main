import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";
import NotificationHelper from "../helpers/notification.helper";

const UserServices = {

    async login(data) {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, data);

        /* if (result.error) {
             NotificationHelper.showErrorNotification(result.error.message);
             return null;
         }

         let success = result.success;
         let {isAdmin, username} = success.data;

         CookieHelper.pushCookie('isAdmin', result.isAdmin, 24);
         CookieHelper.pushCookie('username', result.username, 24);

         NotificationHelper.showSuccessNotification(success.message);*/

        return result;
    },

    /*TODO:*/
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
    }
};

export default UserServices;
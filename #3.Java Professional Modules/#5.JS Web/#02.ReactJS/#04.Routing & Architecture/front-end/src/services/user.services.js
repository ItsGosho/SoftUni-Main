import RequestHelper from "../helpers/request.helper";
import RestURLs from "../constants/rest.url.constants";

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
        console.log(result);
    }
};

export default UserServices;
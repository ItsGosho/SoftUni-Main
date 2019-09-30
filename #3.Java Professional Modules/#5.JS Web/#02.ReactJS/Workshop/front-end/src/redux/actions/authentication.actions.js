import RequestHelper from "../../helpers/request.helper";
import RestURLs from "../../constants/rest.url.constants";
import NotificationHelper from "../../helpers/notification.helper";
import CookieHelper from "../../helpers/cookie.helper";
import Actions from "../../constants/actions.constants";


/*let login = (username, password) => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, {username, password});
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return;
        }

        let {username, role} = result.data;

        CookieHelper.pushCookie('username', username, 24);
        CookieHelper.pushCookie('role', role, 24);

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
    }
};*/

let registerAction = (username, email, password, confirmPassword) => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, {
            username,
            email,
            password,
            confirmPassword
        });

        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            dispatch({
                type: Actions.REGISTER_FAILED
            });
            return;
        }

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
        dispatch({
            type: Actions.REGISTER_SUCCESS
        });
    }
};

/*
let logout = () => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGOUT);
        let {error} = result;

        if (error) {
            NotificationHelper.showErrorNotification(error.msg);
            return;
        }

        CookieHelper.removeCookie('username');
        CookieHelper.removeCookie('role');

        let {message} = result;
        NotificationHelper.showSuccessNotification(message);
    }
};*/

export {
    registerAction
}
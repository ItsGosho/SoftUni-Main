import RequestHelper from "../../helpers/request.helper";
import RestURLs from "../../constants/rest.url.constants";
import NotificationHelper from "../../helpers/notification.helper";
import CookieHelper from "../../helpers/cookie.helper";
import Actions from "../../constants/actions.constants";


let loginAction = (username, password) => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, {username, password});

        if (result.error) {
            return dispatch({
                type: Actions.LOGIN_FAILED,
                message: result.error.msg
            });
        }

        CookieHelper.pushCookie('username', result.data.username, 24);
        CookieHelper.pushCookie('role', result.data.role, 24);

        return dispatch({
            type: Actions.LOGIN_SUCCESS,
            message: result.message
        });
    }
};

let registerAction = (username, email, password, confirmPassword) => {
    return async (dispatch) => {

        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.REGISTER, {
            username,
            email,
            password,
            confirmPassword
        });

        if (result.error) {
            return dispatch({
                type: Actions.REGISTER_FAILED,
                message: result.error.msg
            });
        }

        return dispatch({
            type: Actions.REGISTER_SUCCESS,
            message: result.message
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
    registerAction,
    loginAction
}
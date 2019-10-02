import RequestHelper from "../../helpers/request.helper";
import RestURLs from "../../constants/rest.url.constants";
import CookieHelper from "../../helpers/cookie.helper";
import Actions from "../../constants/actions.constants";


let loginAction = (username, password) => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGIN, {username, password});

        if (result.error) {
            dispatch({
                type: Actions.LOGIN_FAILED,
                message: result.error.msg
            });
            return;
        }

        CookieHelper.pushCookie('username', result.data.username, 24);
        CookieHelper.pushCookie('role', result.data.role, 24);

        dispatch({
            type: Actions.LOGIN_SUCCESS,
            message: result.message
        });

        dispatch(addAuthenticatedUserAction(result.data.username, result.data.role));
    }
};

let logoutAction = () => {
    return async (dispatch) => {
        let result = await RequestHelper.postData(RestURLs.AUTHENTICATION.LOGOUT);

        if (result.error) {
            dispatch({
                type: Actions.LOGOUT_FAILED,
                message: result.error.msg
            });
            return;
        }

        CookieHelper.removeCookie('username');
        CookieHelper.removeCookie('role');

        dispatch({
            type: Actions.LOGOUT_SUCCESS,
            message: result.message
        });

        dispatch(removeAuthenticatedUserAction());
        dispatch(loginResetStateAction());
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

        dispatch({
            type: Actions.REGISTER_SUCCESS,
            message: result.message
        });
    }
};

let addAuthenticatedUserAction = (username, role) => {
    return async (dispatch) => {
        dispatch({
            type: Actions.ADD_AUTHENTICATED_USER,
            username,
            role
        });
    };
};

let removeAuthenticatedUserAction = () => {
    return async (dispatch) => {
        dispatch({
            type: Actions.REMOVE_AUTHENTICATED_USER,
        });
    };
};

let loginResetStateAction = () => {
    return async (dispatch) => {
        dispatch({
            type: Actions.LOGIN_RESET_STATE,
        });
    }
};

let registerResetStateAction = () => {
    return async (dispatch) => {
        dispatch({
            type: Actions.REGISTER_RESET_STATE,
        });
    }
};

let logoutResetStateAction = () => {
    return async (dispatch) => {
        dispatch({
            type: Actions.LOGOUT_RESET_STATE,
        });
    }
};

export {
    registerAction,
    loginAction,

    addAuthenticatedUserAction,
    removeAuthenticatedUserAction,

    logoutAction
}
import RequestHelper from "../../helpers/request.helper";
import RestURLs from "../../constants/rest.url.constants";
import CookieHelper from "../../helpers/cookie.helper";
import Actions from "../../constants/actions.constants";


let fetchAll = () => {
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

export {
    registerAction,
    loginAction,

    addAuthenticatedUserAction,
    removeAuthenticatedUserAction,

    logoutAction
}
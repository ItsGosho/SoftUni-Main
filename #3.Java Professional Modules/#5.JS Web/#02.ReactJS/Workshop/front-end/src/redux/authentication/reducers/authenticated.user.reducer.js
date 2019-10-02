import Actions from "../../../constants/actions.constants";
import CookieHelper from "../../../helpers/cookie.helper";

let initialState = {
    username: CookieHelper.getCookie('username'),
    role: CookieHelper.getCookie('role'),
    isAuthenticated: CookieHelper.getCookie('role') !== undefined
};

let authenticatedUserReducer = (state = initialState, action) => {
    let {role, username} = action;

    switch (action.type) {
        case Actions.ADD_AUTHENTICATED_USER:
            return Object.assign({}, state, {role, username, isAuthenticated: true});
        case Actions.REMOVE_AUTHENTICATED_USER:
            return  Object.assign({}, state, {role: '', username: '', isAuthenticated:false});
        default:
            return state;
    }
};

export default authenticatedUserReducer;
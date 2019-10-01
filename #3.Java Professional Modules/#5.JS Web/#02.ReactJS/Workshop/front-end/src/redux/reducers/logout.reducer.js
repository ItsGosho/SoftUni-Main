import Actions from "../../constants/actions.constants";
import NotificationHelper from "../../helpers/notification.helper";

let initialState = {isSuccessful: false, message: ''};

let logoutReducer = (state = initialState, action) => {
    let {message} = action;

    switch (action.type) {
        case Actions.LOGOUT_SUCCESS:
            NotificationHelper.showSuccessNotification(message);
            return Object.assign({}, state, {isSuccessful: true, message: message});
        case Actions.LOGOUT_FAILED:
            NotificationHelper.showErrorNotification(message);
            return Object.assign({}, state, {isSuccessful: false, message: message});
        default:
            return state;
    }
};

export default logoutReducer;
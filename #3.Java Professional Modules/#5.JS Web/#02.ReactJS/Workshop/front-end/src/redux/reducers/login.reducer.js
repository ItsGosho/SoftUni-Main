import Actions from "../../constants/actions.constants";
import NotificationHelper from "../../helpers/notification.helper";

let initialState = {isSuccessful: false, message: ''};

let loginReducer = (state = initialState, action) => {
    let {message} = action;

    switch (action.type) {
        case Actions.LOGIN_RESET_STATE:
            return initialState;
        case Actions.LOGIN_SUCCESS:
            NotificationHelper.showSuccessNotification(message);
            return Object.assign({}, state, {isSuccessful: true, message: message});
        case Actions.LOGIN_FAILED:
            NotificationHelper.showErrorNotification(message);
            return Object.assign({}, state, {isSuccessful: false, message: message});
        default:
            return state;
    }
};

export default loginReducer;
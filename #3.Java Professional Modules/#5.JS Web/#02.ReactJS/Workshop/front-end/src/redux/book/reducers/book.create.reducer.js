import Actions from "../../../constants/actions.constants";
import NotificationHelper from "../../../helpers/notification.helper";

let initialState = {
    isSuccessful: false,
    message: ''
};

let bookCreateReducer = (state = initialState, action) => {
    let {message} = action;

    switch (action.type) {
        case Actions.BOOK_CREATE_SUCCESS:
            NotificationHelper.showSuccessNotification(message);
            return Object.assign({}, state, {isSuccessful: true, message});
        case Actions.BOOK_CREATE_FAILED:
            NotificationHelper.showErrorNotification(message);
            return Object.assign({}, state, {isSuccessful: false, message});
        default:
            return state;
    }
};

export default bookCreateReducer;
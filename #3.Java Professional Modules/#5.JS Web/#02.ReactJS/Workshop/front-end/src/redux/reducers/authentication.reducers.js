import Actions from "../../constants/actions.constants";

let registerInitialState = {isSuccessful: false, message: ''};

let registerReducer = (state = registerInitialState, action) => {
    let {message} = action;

    switch (action.type) {
        case Actions.REGISTER_SUCCESS:
            return Object.assign({}, state, {isSuccessful: true, message: message});
        case Actions.REGISTER_FAILED:
            return Object.assign({}, state, {isSuccessful: false, message: message});
        default:
            return state;
    }
};

export {
    registerReducer
}
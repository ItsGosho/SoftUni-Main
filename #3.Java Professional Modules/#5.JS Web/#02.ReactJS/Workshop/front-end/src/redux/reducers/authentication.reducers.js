import Actions from "../../constants/actions.constants";

let registerReducer = (state = {isSuccessful: false}, action) => {
    switch (action.type) {
        case Actions.REGISTER_SUCCESS:
            return Object.assign({}, state, {isSuccessful: true});
        case Actions.REGISTER_FAILED:
            return Object.assign({}, state, {isSuccessful: false});
        default:
            return state;
    }
};

export {
    registerReducer
}
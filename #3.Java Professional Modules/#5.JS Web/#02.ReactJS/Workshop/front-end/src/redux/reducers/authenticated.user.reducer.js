import Actions from "../../constants/actions.constants";

let authenticatedUserInitialState = {role: '', username: ''};

let authenticatedUserReducer = (state = authenticatedUserInitialState, action) => {
    let {role, username} = action;

    switch (action.type) {
        case Actions.ADD_AUTHENTICATED_USER:
            return Object.assign({}, state, {role, username});
        case Actions.REMOVE_AUTHENTICATED_USER:
            return authenticatedUserInitialState;
        default:
            return state;
    }
};

export default authenticatedUserReducer;
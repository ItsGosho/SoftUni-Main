import Actions from "../../../constants/actions.constants";

let initialState = {
    books: []
};

let bookFetchReducer = (state = initialState, action) => {
    let {books} = action;

    switch (action.type) {
        case Actions.BOOK_FETCH_ALL:
            return Object.assign({}, state, {books});
        default:
            return state;
    }
};

export default bookFetchReducer;
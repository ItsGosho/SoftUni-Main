import React from 'react';
import {connect} from "react-redux";
import {
    addAuthenticatedUserAction,
    removeAuthenticatedUserAction
} from "../actions/authentication.actions";

let props = (state) => {
    return {redux: state.authenticatedUser}
};

let dispatcher = (dispatch) => {
    return {
        addUser: (username, role) => dispatch(addAuthenticatedUserAction(username, role)),
        removeUser: () => dispatch(removeAuthenticatedUserAction())
    }
};

let authenticatedUserReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default authenticatedUserReduxHoc;
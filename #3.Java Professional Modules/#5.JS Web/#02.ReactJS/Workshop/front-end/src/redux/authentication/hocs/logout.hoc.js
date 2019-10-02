import React from 'react';
import {connect} from "react-redux";
import {loginAction, logoutAction} from "../actions/authentication.actions";

let props = (state) => {
    return {redux: state.logout}
};

let dispatcher = (dispatch) => {
    return {
        logout: () => dispatch(logoutAction())
    }
};

let logoutReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default logoutReduxHoc;
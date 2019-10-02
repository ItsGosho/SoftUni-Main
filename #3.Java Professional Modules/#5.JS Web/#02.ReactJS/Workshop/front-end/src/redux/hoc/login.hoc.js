import React from 'react';
import {connect} from "react-redux";
import {loginAction} from "../actions/authentication.actions";

let props = (state) => {
    return {redux: state.login}
};

let dispatcher = (dispatch) => {
    return {
        login: (username, password) => dispatch(loginAction(username, password))
    }
};

let LoginReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default LoginReduxHoc;
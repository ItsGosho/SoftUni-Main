import React from 'react';
import {connect} from "react-redux";
import {registerAction} from "../actions/authentication.actions";

let props = (state) => {
    return {isSuccessful: state}
};

let dispatcher = (dispatch) => {
    return {
        register: (username, email, password, confirmPassword) => dispatch(registerAction(username, email, password, confirmPassword))
    }
};

let RegistrationHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default RegistrationHoc;
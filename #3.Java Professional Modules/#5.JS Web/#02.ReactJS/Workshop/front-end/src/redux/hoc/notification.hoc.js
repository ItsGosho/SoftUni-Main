import React from 'react';
import {connect} from "react-redux";
import {registerAction} from "../actions/authentication.actions";

let props = (state) => {
    return {redux: state.test}
};


let NotificationHoc = (Comp) => {
    return connect(props)((props) => (<Comp {...props}/>));
};

export default NotificationHoc;
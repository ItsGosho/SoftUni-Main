import React from 'react';
import {connect} from "react-redux";
import {registerAction} from "../actions/authentication.actions";
import {fetchAllBooksAction} from "../actions/book.actions";

let props = (state) => {
    return {redux: state.book}
};

let dispatcher = (dispatch) => {
    return {
        fetchAll: () => dispatch(fetchAllBooksAction())
    }
};

let bookReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default bookReduxHoc;
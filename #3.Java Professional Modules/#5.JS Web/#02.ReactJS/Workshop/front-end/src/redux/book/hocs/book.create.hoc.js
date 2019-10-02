import React from 'react';
import {connect} from "react-redux";
import {registerAction} from "../../authentication/actions/authentication.actions";
import {createBookAction, fetchAllBooksAction} from "../actions/book.actions";

let props = (state) => {
    return {redux: state.bookCreate}
};

let dispatcher = (dispatch) => {
    return {
        create: (title, genres, description, image, author, price) => dispatch(createBookAction(title, genres, description, image, author, price))
    }
};

let bookCreateReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default bookCreateReduxHoc;
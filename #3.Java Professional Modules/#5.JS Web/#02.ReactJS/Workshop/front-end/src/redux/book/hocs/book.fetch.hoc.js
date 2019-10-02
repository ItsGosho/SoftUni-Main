import React from 'react';
import {connect} from "react-redux";
import {registerAction} from "../../authentication/actions/authentication.actions";
import {fetchAllBooksAction} from "../actions/book.actions";

let props = (state) => {
    return {redux: state.bookFetch}
};

let dispatcher = (dispatch) => {
    return {
        fetchAll: () => dispatch(fetchAllBooksAction())
    }
};

let bookFetchReduxHoc = (Comp) => {
    return connect(props, dispatcher)((props) => (<Comp {...props}/>));
};

export default bookFetchReduxHoc;
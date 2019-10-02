import React, {Component, Fragment} from 'react';
import logoutReduxHoc from "../../redux/hoc/logout.hoc";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import CookieHelper from "../../helpers/cookie.helper";

class Logout extends Component {

    render() {

        if (CookieHelper.getCookie('role') !== undefined) {
            this.props.logout();
        }

        let {isSuccessful} = this.props.redux;

        return (
            <Fragment>
                {isSuccessful ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </Fragment>
        );
    }
}

export default logoutReduxHoc(Logout);
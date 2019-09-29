import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class GuestNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.AUTHENTICATION.LOGIN} className="active" aria-current="page">Login</Link>
                <Link to={RoutingURLs.AUTHENTICATION.REGISTER}>Register</Link>
            </Fragment>
        );
    }
}

export default GuestNavigation;
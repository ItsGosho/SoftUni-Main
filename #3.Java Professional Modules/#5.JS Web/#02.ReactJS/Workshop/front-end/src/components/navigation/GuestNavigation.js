import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class GuestNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.LOGIN} className="active" aria-current="page">Login</Link>
                <Link to={RoutingURLs.REGISTER}>Register</Link>
            </Fragment>
        );
    }
}

export default GuestNavigation;
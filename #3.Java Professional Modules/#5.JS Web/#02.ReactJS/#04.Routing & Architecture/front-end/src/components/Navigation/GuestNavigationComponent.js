import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class GuestNavigationComponent extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        return (
            <Fragment>
                <span>
                  <Link to={RoutingURLs.AUTHENTICATION.LOGIN}>Login</Link>
                  <Link to={RoutingURLs.AUTHENTICATION.REGISTER}>Register</Link>
                </span>
            </Fragment>

        );
    }
}

export default GuestNavigationComponent;

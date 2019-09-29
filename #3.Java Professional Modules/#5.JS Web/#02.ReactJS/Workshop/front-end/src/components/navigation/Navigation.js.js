import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class Navigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.HOME}>Book Store</Link>
                <Link to={RoutingURLs.HOME} className="active" aria-current="page">Home</Link>
                <Link to={RoutingURLs.STORE}>Store</Link>
            </Fragment>
        );
    }
}

export default Navigation;
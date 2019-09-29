import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class UserNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.ORDER.MY}>My Orders</Link>
                <Link to={RoutingURLs.OTHER.CART}>Cart</Link>
                <Link to={RoutingURLs.AUTHENTICATION.LOGOUT}>Logout</Link>
            </Fragment>
        );
    }
}

export default UserNavigation;
import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class UserNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.MY_ORDERS}>My Orders</Link>
                <Link to={RoutingURLs.CART}>Cart</Link>
                <Link to={RoutingURLs.LOGOUT}>Logout</Link>
            </Fragment>
        );
    }
}

export default UserNavigation;
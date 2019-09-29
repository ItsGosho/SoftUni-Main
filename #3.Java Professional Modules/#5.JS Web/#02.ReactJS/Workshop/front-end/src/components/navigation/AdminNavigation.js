import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class AdminNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.BOOK.CREATE} className="active" aria-current="page">Create New Book</Link>
                <Link to={RoutingURLs.ORDERS.PENDING}>Pending Orders</Link>
                <Link to={RoutingURLs.AUTHENTICATION.LOGOUT}>Logout</Link>
            </Fragment>
        );
    }
}

export default AdminNavigation;
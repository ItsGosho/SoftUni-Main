import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class AdminNavigation extends Component {

    render() {
        return (
            <Fragment>
                <Link to={RoutingURLs.CREATE_BOOK} className="active" aria-current="page">Create New Book</Link>
                <Link to={RoutingURLs.PENDING_ORDERS}>Pending Orders</Link>
                <Link to={RoutingURLs.LOGOUT}>Logout</Link>
            </Fragment>
        );
    }
}

export default AdminNavigation;
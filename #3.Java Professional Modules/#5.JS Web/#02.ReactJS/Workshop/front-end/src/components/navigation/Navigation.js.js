import React, {Component, Fragment} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import Roles from "../../constants/roles.constants";
import UserNavigation from "./UserNavigation";
import AdminNavigation from "./AdminNavigation";
import GuestNavigation from "./GuestNavigation";

class Navigation extends Component {

    render() {
        let role = 'User';

        return (
            <Fragment>
                <Link to={RoutingURLs.HOME}>Book Store</Link>
                <Link to={RoutingURLs.HOME} className="active" aria-current="page">Home</Link>
                <Link to={RoutingURLs.STORE}>Store</Link>

                {() => {
                    switch (role) {
                        case Roles.USER:
                            return (<UserNavigation/>);
                        case Roles.ADMIN:
                            return (<AdminNavigation/>);
                        default:
                            return (<GuestNavigation/>);
                    }
                }};
            </Fragment>
        );
    }
}

export default Navigation;
import React, {Component} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import Roles from "../../constants/roles.constants";
import UserNavigation from "./UserNavigation";
import AdminNavigation from "./AdminNavigation";
import GuestNavigation from "./GuestNavigation";
import authenticatedUserHoc from "../../redux/hoc/authenticated.user.hoc";

class Navigation extends Component {

    render() {
        let {username,role} = this.props.redux;

        return (
            <nav className="navbar-menu">
                <Link to={RoutingURLs.HOME}>Book Store</Link>
                <Link to={RoutingURLs.HOME} className="active" aria-current="page">Home</Link>
                <Link to={RoutingURLs.OTHER.STORE}>Store</Link>

                {(() => {
                    switch (role) {
                        case Roles.USER:
                            return <UserNavigation/>;
                        case Roles.ADMIN:
                            return <AdminNavigation/>;
                        default:
                            return <GuestNavigation/>;
                    }
                })()};
            </nav>
        );
    }
}

export default authenticatedUserHoc(Navigation);
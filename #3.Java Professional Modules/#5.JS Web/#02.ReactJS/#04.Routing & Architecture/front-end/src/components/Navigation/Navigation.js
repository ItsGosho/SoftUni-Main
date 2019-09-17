import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import RoutingURLs from "../../constants/routing.url.constants";

import GuestNavigation from "./GuestNavigation";
import AdminNavigation from "./AdminNavigation";
import UserNavigation from "./UserNavigation";
import userContextHoc from "../contexts/user.context.hoc";

class Navigation extends Component {

    render() {
        let {role, username} = this.props.userContext;
        return (
            <header>
                <a href="#default" className="logo">Interactive IMDB</a>
                <div className="header-right">
                    <Link to={RoutingURLs.HOME}>Home</Link>

                    {(() => {
                        switch (role) {
                            case 'User':
                                return (<UserNavigation username={username}/>);
                            case 'Admin':
                                return (<AdminNavigation username={username}/>);
                            default:
                                return (<GuestNavigation/>);
                        }
                    })()}

                </div>
            </header>
        );
    }
}

export default userContextHoc(Navigation);

import React, {Component, Fragment} from 'react';
import {Link} from 'react-router-dom';
import RoutingURLs from "../../constants/routing.url.constants";

import GuestNavigation from "./GuestNavigation";
import AdminNavigation from "./AdminNavigation";
import UserNavigation from "./UserNavigation";

class Navigation extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {role,username} = this.props;

        return (
            <header>
                <a href="#default" className="logo">Interactive IMDB</a>
                <div className="header-right">
                    <Link to={RoutingURLs.HOME}>Home</Link>

                    {(() => {
                        switch (role) {
                            case 'Guest':
                                return (<GuestNavigation/>);
                            case 'User':
                                return (<UserNavigation username={username}/>);
                            case 'Admin':
                                return (<AdminNavigation username={username}/>);
                        }
                    })()}

                </div>
            </header>
        );
    }
}

export default Navigation;

import React, {Component, Fragment} from 'react';
import {Link} from 'react-router-dom';
import RoutingURLs from "../../constants/routing.url.constants";

import GuestNavigationComponent from "./GuestNavigationComponent";
import AdminNavigationComponent from "./AdminNavigationComponent";
import UserNavigationComponent from "./UserNavigationComponent";

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
                                return (<GuestNavigationComponent/>);
                            case 'User':
                                return (<UserNavigationComponent username={username}/>);
                            case 'Admin':
                                return (<AdminNavigationComponent username={username}/>);
                        }
                    })()}

                </div>
            </header>
        );
    }
}

export default Navigation;

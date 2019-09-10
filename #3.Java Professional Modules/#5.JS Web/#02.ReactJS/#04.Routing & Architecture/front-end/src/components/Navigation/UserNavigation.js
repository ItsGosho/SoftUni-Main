import React, {Component, Fragment} from 'react';
import {Link} from 'react-router-dom';
import RoutingURLs from "../../constants/routing.url.constants";

class UserNavigation extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {username} = this.props;

        return (
            <Fragment>
                <span>
                    <Link to={RoutingURLs.HOME}>Welcome {username}!</Link>
                    <Link to={RoutingURLs.AUTHENTICATION.LOGOUT}>Logout</Link>
                </span>
            </Fragment>

        );
    }
}

export default UserNavigation;

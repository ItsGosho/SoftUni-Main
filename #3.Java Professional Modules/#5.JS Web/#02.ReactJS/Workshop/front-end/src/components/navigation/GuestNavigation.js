import React, {Component, Fragment} from 'react';

class GuestNavigation extends Component {

    render() {
        return (
            <Fragment>
                <a href="/login" className="active" aria-current="page">Login</a>
                <a href="/register">Register</a>
            </Fragment>
        );
    }
}

export default GuestNavigation;
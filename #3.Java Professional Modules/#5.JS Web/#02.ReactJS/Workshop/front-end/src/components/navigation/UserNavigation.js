import React, {Component, Fragment} from 'react';

class UserNavigation extends Component {

    render() {
        return (
            <Fragment>
                <a href="/orders">My Orders</a>
                <a href="/cart">Cart</a>
                <a href="javascript:void(0)">Logout</a>
            </Fragment>
        );
    }
}

export default UserNavigation;
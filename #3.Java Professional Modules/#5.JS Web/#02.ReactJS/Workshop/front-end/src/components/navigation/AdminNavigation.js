import React, {Component, Fragment} from 'react';

class AdminNavigation extends Component {

    render() {
        return (
            <Fragment>
                <a href="/">Book Store</a>
                <a href="/">Home</a>
                <a href="/store">Store</a>
                <a href="/admin/create" className="active" aria-current="page">Create New Book</a>
                <a href="/admin/orders/pending">Pending Orders</a>
                <a href="javascript:void(0)">Logout</a>
            </Fragment>
        );
    }
}

export default AdminNavigation;
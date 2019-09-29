import React, {Component, Fragment} from 'react';

class Navigation extends Component {

    render() {
        return (
            <Fragment>
                <a href="/">Book Store</a>
                <a href="/" className="active" aria-current="page">Home</a>
                <a href="/store">Store</a>
            </Fragment>
        );
    }
}

export default Navigation;
import React,{Component} from 'react';

class WelcomeHomeHeader extends Component {

    render() {
        return (
            <div className="welcome">
                <h1>Welcome to our book store, tanya !</h1>
                <p><a href="/store">Go To Store</a><a href="/orders">View your orders</a></p>
            </div>
        );
    }
}

export default WelcomeHomeHeader;
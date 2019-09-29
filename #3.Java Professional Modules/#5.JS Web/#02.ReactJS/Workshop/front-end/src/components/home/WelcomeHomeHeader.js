import React,{Component} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class WelcomeHomeHeader extends Component {

    render() {
        return (
            <div className="welcome">
                <h1>Welcome to our book store, tanya !</h1>
                <p>
                    <Link to={RoutingURLs.OTHER.STORE}>Go To Store</Link>
                    <Link to={RoutingURLs.ORDER.MY}>View your orders</Link>
                </p>
            </div>
        );
    }
}

export default WelcomeHomeHeader;
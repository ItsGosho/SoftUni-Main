import React, {Component} from 'react';
import WelcomeHomeHeader from "./WelcomeHomeHeader";
import TopRatedBooks from "./TopRatedBooks";

class Home extends Component {

    render() {

        return (
            <div className="welcome-wrapper">
                <WelcomeHomeHeader/>
                <h2>Top Rated</h2>
                <TopRatedBooks/>
            </div>
        );
    }
}

export default Home;
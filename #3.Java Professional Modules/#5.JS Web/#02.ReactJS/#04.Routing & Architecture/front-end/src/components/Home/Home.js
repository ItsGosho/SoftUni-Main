import React, {Component, Fragment} from 'react';
import './Home.css'
import HomeGuest from "./HomeGuest";
import HomeUser from "./HomeUser";
import HomeAdmin from "./HomeAdmin";

class Home extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {role} = this.props;


        return (
            <div className="Home">
                <div className="Home">
                    <h1>All movies</h1>
                    <ul className="movies">
                        {(() => {
                            switch (role) {
                                case 'Guest':
                                    return (<HomeGuest/>);
                                case 'User':
                                    return (<HomeUser/>);
                                case 'Admin':
                                    return (<HomeAdmin/>);
                            }
                        })()}
                    </ul>
                </div>
            </div>
        );
    }
}

export default Home;

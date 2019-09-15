import React, {Component, Fragment} from 'react';
import RoutingURLs from "../../constants/routing.url.constants";
import {Redirect} from "react-router-dom";
import UserServices from "../../services/user.services";

class Logout extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoggedOut: false
        }
    }

    async componentDidMount() {
        let result = await UserServices.logout();
        this.setState({isLoggedOut: result});
    }

    render() {
        let {isLoggedOut} = this.state;
        return (
            <Fragment>
                {isLoggedOut ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </Fragment>
        );
    }

}

export default Logout;

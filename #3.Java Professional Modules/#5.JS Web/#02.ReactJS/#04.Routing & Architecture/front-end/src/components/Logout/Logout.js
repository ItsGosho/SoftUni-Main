import React, {Component, Fragment} from 'react';
import RoutingURLs from "../../constants/routing.url.constants";
import {Redirect} from "react-router-dom";
import UserServices from "../../services/user.services";
import userContextHoc from "../contexts/user.context.hoc";

class Logout extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoggedOut: false,
            refreshUserContext: this.props.userContext.refreshData
        };
    }

    async componentDidMount() {
        let result = await UserServices.logout();
        this.setState({isLoggedOut: result});
        this.state.refreshUserContext();
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

export default userContextHoc(Logout);

import React, {Component} from 'react';
import './Login.css';
import UserServices from "../../services/user.services";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import formHoc from "../hoc/form.hoc";

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoginFinished: false
        };

        this.onSubmit = this.onSubmit.bind(this);
    }

    async onSubmit(event) {
        event.preventDefault();

        let {username, password} = this.props.formData;
        let data = {username, password};

        let isSuccessful = await UserServices.login(data);
        this.setState({isLoginFinished: isSuccessful});
    }

    render() {
        let {onChange} = this.props.formMethods;

        return (
            <div className="Login">
                <h1>Login</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="usernameLogin">Username</label>
                    <input name="username" type="text" id="usernameLogin" placeholder="Ivan Ivanov"
                           onChange={onChange}/>
                    <label htmlFor="passwordLogin">Password</label>
                    <input name="password" type="password" id="passwordLogin" placeholder="******"
                           onChange={onChange}/>
                    <input type="submit" value="Login"/>
                </form>

                {this.state.isLoginFinished ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </div>
        );
    }
}

export default formHoc(Login);

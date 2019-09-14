import React, {Component} from 'react';
import './Register.css';
import UserServices from "../../services/user.services";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class Register extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: '',
            password: '',
            confirmPassword: '',
            isRegistrationFinished: false
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(event) {
        let inputName = event.target.name;
        let value = event.target.value;

        this.setState({[inputName]: value});
        event.preventDefault();
    }

    async onSubmit(event) {
        event.preventDefault();

        let {username, password, confirmPassword, email} = this.state;
        let data = {username, password, confirmPassword, email};

        let result = await UserServices.register(data);
        this.setState({isRegistrationFinished: result});
    }

    render() {
        return (
            <div className="Register">
                <h1>Register</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="username">Username</label>
                    <input name="username" type="text" id="username" placeholder="Ivan Ivanov"
                           onChange={this.onChange}/>
                    <label htmlFor="email">Email</label>
                    <input name="email" type="text" id="email" placeholder="ivan@gmail.com" onChange={this.onChange}/>
                    <label htmlFor="password">Password</label>
                    <input name="password" type="password" id="password" placeholder="******" onChange={this.onChange}/>
                    <label htmlFor="password">Confirm Password</label>
                    <input name="confirmPassword" type="password" id="confirmPassword" placeholder="******"
                           onChange={this.onChange}/>
                    <input type="submit" value="Register"/>
                </form>

                {this.state.isRegistrationFinished ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </div>
        );
    }
}

export default Register;

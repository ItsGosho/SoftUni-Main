import React, {Component} from 'react';
import './Register.css';
import UserServices from "../../services/user.services";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import formHoc from "../hoc/form.hoc";

class Register extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isRegistrationFinished: false
        };

        this.onSubmit = this.onSubmit.bind(this);
    }

    async onSubmit(event) {
        event.preventDefault();

        let {username, password, confirmPassword, email} = this.props.formData;
        let data = {username, password, confirmPassword, email};

        let isSuccessful = await UserServices.register(data);
        this.setState({isRegistrationFinished: isSuccessful});
    }

    render() {
        let {onChange} = this.props.formMethods;

        return (
            <div className="Register">
                <h1>Register</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="username">Username</label>
                    <input name="username" type="text" id="username" placeholder="Ivan Ivanov"
                           onChange={onChange}/>
                    <label htmlFor="email">Email</label>
                    <input name="email" type="text" id="email" placeholder="ivan@gmail.com" onChange={onChange}/>
                    <label htmlFor="password">Password</label>
                    <input name="password" type="password" id="password" placeholder="******" onChange={onChange}/>
                    <label htmlFor="password">Confirm Password</label>
                    <input name="confirmPassword" type="password" id="confirmPassword" placeholder="******"
                           onChange={onChange}/>
                    <input type="submit" value="Register"/>
                </form>

                {this.state.isRegistrationFinished ? <Redirect to={RoutingURLs.AUTHENTICATION.LOGIN} push/> : null}
            </div>
        );
    }
}

export default formHoc(Register);

import React, {Component} from 'react';
import './Register.css';

class Register extends Component {
    render() {
        return (
            <div className="Register">
                <h1>Register</h1>
                <form action="/">
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" placeholder="Ivan Ivanov"/>
                    <label htmlFor="email">Email</label>
                    <input type="text" id="email" placeholder="ivan@gmail.com"/>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" placeholder="******"/>
                    <input type="submit" value="REGISTER"/>
                </form>
            </div>

        );
    }
}

export default Register;

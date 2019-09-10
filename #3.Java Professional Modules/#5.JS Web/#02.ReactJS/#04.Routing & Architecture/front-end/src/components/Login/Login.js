import React, {Component} from 'react';
import './Login.css';

class Login extends Component {
    render() {
        return (
            <div className="Login">
                <h1>Login</h1>
                <form action="/">
                    <label htmlFor="usernameLogin">Username</label>
                    <input type="text" id="usernameLogin" placeholder="Ivan Ivanov"/>
                    <label htmlFor="passwordLogin">Password</label>
                    <input type="password" id="passwordLogin" placeholder="******"/>
                    <input type="submit" value="Login"/>
                </form>
            </div>

        );
    }
}

export default Login;

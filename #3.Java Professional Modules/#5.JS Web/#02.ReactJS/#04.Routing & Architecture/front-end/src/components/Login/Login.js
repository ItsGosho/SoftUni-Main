import React, {Component} from 'react';
import './Login.css';

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(event) {
        let inputName = event.target.name;
        let value = event.target.value;

        this.setState((prevState) => {
            return this.state[inputName] = value;
        });
        event.preventDefault();
    }

    onSubmit(event) {
        event.preventDefault();

        let {username, password} = this.state;
        let data = {username, password};
        /*TODO: login*/
        console.log(data);
    }

    render() {
        return (
            <div className="Login">
                <h1>Login</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="usernameLogin">Username</label>
                    <input name="username" type="text" id="usernameLogin" placeholder="Ivan Ivanov" onChange={this.onChange}/>
                    <label htmlFor="passwordLogin">Password</label>
                    <input name="password" type="password" id="passwordLogin" placeholder="******" onChange={this.onChange}/>
                    <input type="submit" value="Login"/>
                </form>
            </div>

        );
    }
}

export default Login;

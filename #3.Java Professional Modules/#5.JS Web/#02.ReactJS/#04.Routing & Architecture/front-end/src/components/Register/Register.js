import React, {Component} from 'react';
import './Register.css';

class Register extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: '',
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

        let {username, password, email} = this.state;
        let data = {username, password, email};
        /*TODO: register*/
        console.log(data);
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
                    <input type="submit" value="Register"/>
                </form>
            </div>

        );
    }
}

export default Register;

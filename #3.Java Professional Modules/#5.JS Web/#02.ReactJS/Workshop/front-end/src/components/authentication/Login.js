import React, {Component} from 'react';
import Form from "../../hoc/form.hoc";
import LoginHoc from "../../redux/hoc/login.hoc";

class Login extends Component {

    constructor(props) {
        super(props);

        this.onSubmit = this.onSubmit.bind(this);
    }


    onSubmit(event) {
        event.preventDefault();

        let {username, password} = this.props.formData;

        this.props.login(username, password);
    }

    render() {
        let {onFormChange} = this.props;

        return (
            <div className="form-wrapper">
                <h1>Login</h1>
                <form onSubmit={this.onSubmit}>
                    <div className="form-group">
                        <label htmlFor="email">E-mail</label>
                        <input type="text" name="email" id="email" placeholder="Enter e-mail" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" name="password" id="password" placeholder="Enter password" onChange={onFormChange}/>
                    </div>
                    <input type="submit" value="Login"/>
                </form>
            </div>
        );
    }
}

export default LoginHoc(Form(Login));
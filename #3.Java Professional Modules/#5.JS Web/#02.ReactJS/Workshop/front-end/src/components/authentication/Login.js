import React, {Component} from 'react';
import Form from "../../hoc/form.hoc";

class Login extends Component {

    render() {
        let {onFormChange} = this.props;

        return (
            <div className="form-wrapper">
                <h1>Login</h1>
                <form>
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

export default Form(Login);
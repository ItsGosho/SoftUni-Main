import React, {Component} from 'react';
import Form from "../../hoc/form.hoc";

class Register extends Component {

    render() {
        let {onFormChange} = this.props;

        return (
            <div className="form-wrapper">
                <h1>Register</h1>
                <form>
                    <div className="form-group">
                        <label htmlFor="email">E-mail</label>
                        <input type="text" name="email" id="email" placeholder="Enter e-mail" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input type="text" name="username" id="username" placeholder="Enter username" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" name="password" id="password" placeholder="Enter password" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="confirmPassword">Confirm Password</label>
                        <input type="password" name="confirmPassword" id="confirmPassword"
                               placeholder="Enter your password again" onChange={onFormChange}/>
                    </div>
                    <input type="submit" value="Register"/>
                </form>
            </div>
        );
    }
}

export default Form(Register);
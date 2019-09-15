import React, {Component} from 'react';
import CookieHelper from "../../helpers/cookie.helper";

let roleHoc = (Comp, role) => {
    return class extends Component {

        getRole() {
            return CookieHelper.getCookie('role');
        }

        render() {
            if (this.getRole() !== undefined && this.getRole().toLowerCase() === role.toLowerCase()) {
                return (
                    <Comp {...this.props}/>
                );
            }

            return (
                <center><h1 style={{'color': 'red'}}>You are not authorized!</h1></center>
            );
        }
    }
};

export default roleHoc;
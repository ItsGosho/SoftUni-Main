import React, {Component} from 'react';
import CookieHelper from "../../helpers/cookie.helper";

let loggedOutHoc = (Comp) => {
    return class extends Component {

        getRole() {
            return CookieHelper.getCookie('role');
        }

        render() {
            if (this.getRole() === undefined) {
                return (
                    <Comp {...this.props}/>
                );
            }

            return (
                <center><h1 style={{'color': 'red'}}>You must be logged out!</h1></center>
            );
        }
    }
};

export default loggedOutHoc;
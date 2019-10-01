import React, {Component} from 'react';
import CookieHelper from "../helpers/cookie.helper";
import NotificationHelper from "../helpers/notification.helper";

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

            NotificationHelper.showErrorNotification(`Only ${role} can access this!`);
            return null;
        }
    }
};

export default roleHoc;
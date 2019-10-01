import React, {Component} from 'react';
import CookieHelper from "../helpers/cookie.helper";
import NotificationHelper from "../helpers/notification.helper";

let guestHoc = (Comp) => {
    return class extends Component {

        getRole() {
            return CookieHelper.getCookie('role');
        }

        render() {
            if (this.getRole() !== undefined) {
                return (
                    <Comp {...this.props}/>
                );
            }

            NotificationHelper.showErrorNotification('You must be logged in!');
            return null;
        }
    }
};

export default guestHoc;
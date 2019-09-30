import React, {Component} from 'react';
import NotificationHoc from "../../redux/hoc/notification.hoc";

class NotificationHandler extends Component {

    constructor(props) {
        super(props);

        this.showProperNotification = this.showProperNotification.bind(this);
    }


    showProperNotification() {
        console.log(this.props);
    }

    render() {
        this.showProperNotification();
        return false;
    }
}

export default NotificationHoc(NotificationHandler);
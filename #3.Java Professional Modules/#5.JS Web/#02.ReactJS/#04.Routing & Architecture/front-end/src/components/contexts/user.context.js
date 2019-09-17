import React, {Component, createContext} from 'react';
import CookieHelper from "../../helpers/cookie.helper";

const {Provider, Consumer} = createContext({
    username: '',
    role: ''
});

class UserProvider extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            role: '',
        };

        this.refreshData = this.refreshData.bind(this);
    }

    refreshData() {
        this.setState({username: CookieHelper.getCookie('username')});
        this.setState({role: CookieHelper.getCookie('role')});
    };

    componentDidMount() {
        this.refreshData();
    }

    render() {
        return (
            <Provider value={this.state}>
                {this.props.children}
            </Provider>
        );
    }
}

export {
    UserProvider,
    Consumer as UserConsumer
}

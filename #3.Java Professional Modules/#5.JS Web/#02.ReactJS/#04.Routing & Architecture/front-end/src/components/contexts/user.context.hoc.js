import React, {Component} from 'react';
import {UserConsumer} from "./user.context";

let userContextHoc = (Comp) => {
    return class extends Component {

        render() {
            return (
                <UserConsumer>
                    {value => <Comp userContext={value} {...this.props}/>}
                </UserConsumer>
            );
        }
    }
};

export default userContextHoc;
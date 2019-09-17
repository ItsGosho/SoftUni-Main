import React, {Component} from 'react';
import {UserConsumer} from "./user.context";

/*Will attach the data from UserContext to the Component`s properties as userContext*/
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
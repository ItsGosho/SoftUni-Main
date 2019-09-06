import React, {Component} from 'react';
import './Street.css';

class Street extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {id, street, onHover} = this.props;

        return (
            <div className="Street"
                 onMouseEnter={(event) => {onHover(id)}}>
                <p className="street-info">{street.location}</p>
            </div>
        );
    }
}

export default Street;

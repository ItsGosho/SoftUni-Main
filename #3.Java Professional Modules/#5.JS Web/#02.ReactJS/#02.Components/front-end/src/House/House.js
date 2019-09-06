import React, {Component} from 'react';
import './House.css';

class House extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {house,onHover,id} = this.props;

        return (
            <div className="House" onMouseEnter={(event) => {onHover(id)}}>
                <img src={house.imageUrl}/>
            </div>
        );
    }
}

export default House;

import React, {Component} from 'react';
import './HouseDetails.css';

class HouseDetails extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let {house} = this.props;

        return (
            <div className="HouseDetails">
                <h2>{house.type}</h2>
                <div className="image">
                    <img src={house.imageUrl}/>
                </div>
                <p>Description: {house.description}</p>
                <p>Price: {house.price}!</p>
            </div>
        );
    }
}

export default HouseDetails;

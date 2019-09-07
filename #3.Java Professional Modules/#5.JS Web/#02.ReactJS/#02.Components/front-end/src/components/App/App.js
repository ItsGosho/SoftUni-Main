import React, {Component} from 'react';
import './App.css';
import Street from "../Street/Street";
import House from "../House/House";
import HouseDetails from "../HouseDetails/HouseDetails";
import StreetServices from "../../services/street.services";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            streets: [],
            selectedStreetIndex: 0,
            selectedHouseIndex: 0,
            hasFetched: false
        };

        this.onStreetHoverEvent = this.onStreetHoverEvent.bind(this);
        this.onHouseHoverEvent = this.onHouseHoverEvent.bind(this);
    }

    async componentDidMount() {
        let streets = await StreetServices.getAllStreets();

        this.setState((prevState) => ({
            streets: streets,
            hasFetched: true
        }));
    }

    getSelectedStreet() {
        return this.state.selectedStreetIndex >= 0 ? this.state.streets[this.state.selectedStreetIndex].homes : null;
    }

    getSelectedHouse() {
        return this.getSelectedStreet()[this.state.selectedHouseIndex];
    }

    onStreetHoverEvent(index) {
        this.setState((prevState) => ({selectedStreetIndex: index}));
    }

    onHouseHoverEvent(index) {
        this.setState((prevState) => ({selectedHouseIndex: index}));
    }

    render() {
        if (!this.state.hasFetched) {
            return null;
        }

        return (
            <div className="App">
                <div className="streets">
                    <h2>Streets</h2>
                    {this.state.streets.map((street, index) => {
                        return <Street street={street}
                                       key={index}
                                       id={index}
                                       onHover={this.onStreetHoverEvent}/>
                    })}
                </div>
                <div className="houses">
                    <h2>Houses</h2>
                    {this.state.selectedStreetIndex >= 0 ?
                        this.getSelectedStreet().map((house, index) => {
                            return <House
                                house={house}
                                key={index}
                                id={index}
                                onHover={this.onHouseHoverEvent}/>
                        }) : null}
                </div>
                <div className="houses">
                    <h2>Details</h2>
                    <HouseDetails house={this.getSelectedHouse()}/>
                </div>
            </div>
        );
    }
}

export default App;

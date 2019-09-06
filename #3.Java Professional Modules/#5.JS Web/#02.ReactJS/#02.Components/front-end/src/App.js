import React, {Component} from 'react';
import './App.css';
import Street from "./Street/Street";
import House from "./House/House";
import HouseDetails from "./HouseDetails/HouseDetails";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            streets: [],
            selectedStreetIndex: 0,
            selectedHouseIndex: 0,
            hasFetched: false
        }
    }

    componentDidMount() {
        fetch("http://localhost:9999/feed/street/all")
            .then((data) => data.json())
            .then((result) => {
                this.setState({
                    streets: result.streets,
                    hasFetched: true
                });
            });
    }

    getSelectedStreet() {
        return this.state.selectedStreetIndex >= 0 ? this.state.streets[this.state.selectedStreetIndex].homes : null;
    }

    getSelectedHouse() {
        return this.getSelectedStreet()[this.state.selectedHouseIndex];
    }

    onStreetHoverEvent(index) {
        this.setState({
            selectedStreetIndex: index
        });
    }

    onHouseHoverEvent(index) {
        this.setState({
            selectedHouseIndex: index
        });
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
                                       onHover={this.onStreetHoverEvent.bind(this)}/>
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
                                onHover={this.onHouseHoverEvent.bind(this)}/>
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

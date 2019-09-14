import React, {Component} from 'react';
import './Home.css'
import HomeGuest from "./HomeGuest";
import HomeUser from "./HomeUser";
import HomeAdmin from "./HomeAdmin";
import MovieServices from "../../services/movie.services";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            movies: []
        }
    }

    async componentDidMount() {
        let movies = await MovieServices.findAll();
        this.setState((prev) => {
            return this.state.movies = movies;
        })
    }

    render() {
        let {roleName} = this.props;

        return (
            <div className="Home">
                <div className="Home">
                    <h1>All movies</h1>
                    <ul className="movies">
                        {(() => {
                            switch (roleName) {
                                case 'User':
                                    return (<HomeUser movies={this.state.movies}/>);
                                case 'Admin':
                                    return (<HomeAdmin movies={this.state.movies}/>);
                                default:
                                    return (<HomeGuest movies={this.state.movies}/>);
                            }
                        })()}
                    </ul>
                </div>
            </div>
        );
    }
}

export default Home;

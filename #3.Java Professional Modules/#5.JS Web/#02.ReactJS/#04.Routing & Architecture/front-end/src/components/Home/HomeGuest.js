import React, {Component, Fragment} from 'react';
import MovieServices from "../../services/movie.services";

class HomeGuest extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let movies = this.props.movies;

        return (
            <Fragment>
                {movies.map((movie,key) => {
                    return (
                        <li className="movie">
                            <h2>{movie.title}</h2>
                            <img
                                src={movie.poster}/>
                        </li>
                    );
                })}
            </Fragment>
        );
    }

}

export default HomeGuest;
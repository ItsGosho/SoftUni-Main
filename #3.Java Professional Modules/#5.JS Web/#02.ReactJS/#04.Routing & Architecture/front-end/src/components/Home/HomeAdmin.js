import React, {Component, Fragment} from 'react';
import MovieTrailer from "../Movie/MovieTrailer";

class HomeAdmin extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        let movies = this.props.movies;

        return (
            <Fragment>
                <MovieTrailer/>
                {movies.map((movie, key) => {
                    return (
                        <li className="movie">
                            <h2>{movie.title}</h2>
                            <img
                                src={movie.poster}/>
                            <span>
                                <button>View Trailer</button>
                                <button>View Story Line</button>
                            </span>
                        </li>
                    );
                })}
            </Fragment>
        );
    }

}

export default HomeAdmin;
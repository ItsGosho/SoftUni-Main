import React, {Component, Fragment} from 'react';
import MovieTrailer from "../Movie/MovieTrailer";

class HomeAdmin extends Component {

    render() {
        let movies = this.props.movies;

        return (
            <Fragment>
                <MovieTrailer/>
                {movies.map((movie, index) => {
                    return (
                        <li className="movie" key={index}>
                            <h2>{movie.title}</h2>
                            <img style={{'width': '100px'}} alt=""
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
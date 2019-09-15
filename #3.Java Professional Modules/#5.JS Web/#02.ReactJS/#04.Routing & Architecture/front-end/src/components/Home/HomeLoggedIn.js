import React, {Component, Fragment} from 'react';
import MovieTrailer from "../Movie/MovieTrailer";
import MovieStoryline from "../Movie/MovieStoryline";
import trailerHoc from "./hocs/trailer.hoc";
import storyLineHoc from "./hocs/story_line.hoc";

class HomeLoggedIn extends Component {

    render() {
        let {movies} = this.props;
        let {showTrailer, selectedTrailerMovie, onViewTrailer} = this.props;
        let {showStoryLine, selectedStoryLineMovie, onViewStoryLine} = this.props;

        return (
            <Fragment>

                {showTrailer ? (<MovieTrailer movie={selectedTrailerMovie}/>) : null}
                {showStoryLine ? (<MovieStoryline movie={selectedStoryLineMovie}/>) : null}

                {movies.map((movie, index) => {
                    return (
                        <li className="movie" key={index}>
                            <h2>{movie.title}</h2>
                            <img style={{'width': '100px'}} alt=""
                                 src={movie.poster}/>
                            <span>
                                <button onClick={() => (onViewTrailer(movie))}>View Trailer</button>
                                <button onClick={() => (onViewStoryLine(movie))}>View Story Line</button>
                            </span>
                        </li>
                    );
                })}
            </Fragment>
        );
    }

}

export default storyLineHoc(trailerHoc(HomeLoggedIn));
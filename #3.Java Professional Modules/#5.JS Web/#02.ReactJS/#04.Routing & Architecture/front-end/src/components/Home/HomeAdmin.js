import React, {Component, Fragment} from 'react';
import MovieTrailer from "../Movie/MovieTrailer";
import MovieStoryline from "../Movie/MovieStoryline";

class HomeAdmin extends Component {

    constructor(props) {
        super(props);
        this.state = {
            showTrailer: false,
            showStoryLine: false,
            selectedTrailerMovie: null,
            selectedStoryLineMovie: null
        };

        this.onViewTrailer = this.onViewTrailer.bind(this);
        this.onViewStoryLine = this.onViewStoryLine.bind(this);
    }

    onViewTrailer(movie) {
        !this.state.showTrailer ? this.setState({selectedTrailerMovie: movie}) : this.setState({selectedTrailerMovie: null});
        this.setState({showTrailer: !this.state.showTrailer})
    }

    onViewStoryLine(movie) {
        !this.state.showStoryLine ? this.setState({selectedStoryLineMovie: movie}) : this.setState({selectedStoryLineMovie: null});

        this.setState({showStoryLine: !this.state.showStoryLine})
    }

    render() {
        let {movies} = this.props;

        return (
            <Fragment>

                {this.state.showTrailer ? (<MovieTrailer movie={this.state.selectedTrailerMovie}/>) : null}
                {this.state.showStoryLine ? (<MovieStoryline movie={this.state.selectedStoryLineMovie}/>) : null}

                {movies.map((movie, index) => {
                    return (
                        <li className="movie" key={index}>
                            <h2>{movie.title}</h2>
                            <img style={{'width': '100px'}} alt=""
                                 src={movie.poster}/>
                            <span>
                                <button onClick={() => (this.onViewTrailer(movie))}>View Trailer</button>
                                <button onClick={() => (this.onViewStoryLine(movie))}>View Story Line</button>
                            </span>
                        </li>
                    );
                })}
            </Fragment>
        );
    }

}

export default HomeAdmin;
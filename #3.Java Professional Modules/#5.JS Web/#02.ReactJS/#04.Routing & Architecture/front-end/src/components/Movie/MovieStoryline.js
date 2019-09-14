import React, {Component, Fragment} from 'react';

class MovieStoryline extends Component {

    render() {
        let {movie} = this.props;

        return (
            <Fragment>
                <span>
                    <h2>Story line of {movie.title}</h2>
                    <p>{movie.storyLine}</p>
                </span>
            </Fragment>
        );
    }

}

export default MovieStoryline;
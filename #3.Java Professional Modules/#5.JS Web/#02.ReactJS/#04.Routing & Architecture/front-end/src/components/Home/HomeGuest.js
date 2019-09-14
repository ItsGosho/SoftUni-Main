import React, {Component, Fragment} from 'react';

class HomeGuest extends Component {

    render() {
        let movies = this.props.movies;

        return (
            <Fragment>
                {movies.map((movie,index) => {
                    return (
                        <li className="movie" key={index}>
                            <h2>{movie.title}</h2>
                            <img style={{'width': '100px'}} alt=""
                                src={movie.poster}/>
                        </li>
                    );
                })}
            </Fragment>
        );
    }

}

export default HomeGuest;
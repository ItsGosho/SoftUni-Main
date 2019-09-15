import React, {Component} from 'react';
import './Create.css';
import MovieServices from "../../services/movie.services";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class MovieCreate extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: '',
            storyLine: '',
            trailerUrl: '',
            poster: '',
            isCreationFinished: false
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(event) {
        let inputName = event.target.name;
        let value = event.target.value;

        this.setState({[inputName]: value});
        event.preventDefault();
    }

    async onSubmit(event) {
        event.preventDefault();

        let {title, storyLine, trailerUrl, poster} = this.state;
        let data = {title, storyLine, trailerUrl, poster};

        let isSuccessful = await MovieServices.create(data);
        this.setState({isCreationFinished: isSuccessful});
    }

    render() {
        return (
            <div className="Create">
                <h1>Create Movie</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="title">Title</label>
                    <input name="title" type="text" id="title" placeholder="Titanic" onChange={this.onChange}/>
                    <label htmlFor="storyLine">Story Line</label>
                    <input name="storyLine" type="text" id="storyLine" placeholder="Text" onChange={this.onChange}/>
                    <label htmlFor="trailerUrl">Trailer Url</label>
                    <input name="trailerUrl" type="text" id="trailerUrl"
                           placeholder="https://www.youtube.com/watch?v=DNyKDI9pn0Q"
                           onChange={this.onChange}/>
                    <label htmlFor="poster">Movie Poster</label>
                    <input type="text" id="poster" name="poster"
                           placeholder="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRzg6o0KjhufKFU1iBNr1zuyi0YDNgCUw4Ky5SNATZDVKaIUkiAA"
                           onChange={this.onChange}/>
                    <input type="submit" value="Create"/>
                </form>

                {this.state.isCreationFinished ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </div>
        );
    }
}

export default MovieCreate;

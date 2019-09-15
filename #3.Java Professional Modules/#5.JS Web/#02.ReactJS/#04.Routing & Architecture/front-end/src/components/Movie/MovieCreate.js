import React, {Component} from 'react';
import './Create.css';
import MovieServices from "../../services/movie.services";
import {Redirect} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";
import formHoc from "../hoc/form.hoc";

class MovieCreate extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isCreationFinished: false
        };

        this.onSubmit = this.onSubmit.bind(this);
    }

    async onSubmit(event) {
        event.preventDefault();

        let {title, storyLine, trailerUrl, poster} = this.props.formData;
        let data = {title, storyLine, trailerUrl, poster};

        let isSuccessful = await MovieServices.create(data);
        this.setState({isCreationFinished: isSuccessful});
    }

    render() {
        let {onChange} = this.props.formMethods;

        return (
            <div className="Create">
                <h1>Create Movie</h1>
                <form onSubmit={this.onSubmit}>
                    <label htmlFor="title">Title</label>
                    <input name="title" type="text" id="title" placeholder="Titanic" onChange={onChange}/>
                    <label htmlFor="storyLine">Story Line</label>
                    <input name="storyLine" type="text" id="storyLine" placeholder="Text" onChange={onChange}/>
                    <label htmlFor="trailerUrl">Trailer Url</label>
                    <input name="trailerUrl" type="text" id="trailerUrl"
                           placeholder="https://www.youtube.com/watch?v=DNyKDI9pn0Q"
                           onChange={onChange}/>
                    <label htmlFor="poster">Movie Poster</label>
                    <input type="text" id="poster" name="poster"
                           placeholder="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRzg6o0KjhufKFU1iBNr1zuyi0YDNgCUw4Ky5SNATZDVKaIUkiAA"
                           onChange={onChange}/>
                    <input type="submit" value="Create"/>
                </form>

                {this.state.isCreationFinished ? <Redirect to={RoutingURLs.HOME} push/> : null}
            </div>
        );
    }
}

export default formHoc(MovieCreate);

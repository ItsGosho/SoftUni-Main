import React, {Component} from 'react';
import RoutingURLs from "../../constants/routing.url.constants";

class TopRatedBooks extends Component {

    componentDidMount() {
        /*Fetch top rated*/
    }

    render() {
        let topRated = [];

        return (
            <div className="row">
                <div className="card-deck space-top">

                    {topRated.map((movie, index) => {
                        let {id, title, description, image} = movie;
                        let detailsUrl = RoutingURLs.BOOK.DETAILS.replace(':id', id);

                        return (
                            <div className="card col-4" key={index}>
                                <img className="card-img-top card-image" src={image} alt={title}/>
                                <div className="card-body">
                                    <h5 className="card-title">{title}</h5>
                                    <p className="card-text">{description}</p>
                                </div>
                                <div className="card-footer">
                                    <small className="text-muted"/>
                                    <a type="button" className="btn btn-primary float-right btn-sm"
                                       href={detailsUrl}>Details</a>
                                    <button type="button" className="btn btn-warning float-right btn-sm">Order</button>
                                </div>
                            </div>
                        );
                    })};

                </div>
            </div>
        );
    }
}

export default TopRatedBooks;
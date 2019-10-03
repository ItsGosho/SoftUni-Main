import React, {Component} from 'react';
import RoutingURLs from "../../constants/routing.url.constants";
import bookFetchReduxHoc from "../../redux/book/hocs/book.fetch.hoc";

class TopRatedBooks extends Component {

    componentDidMount() {
        this.props.fetchAll();
    }

    render() {
        let books = [...this.props.redux.books];
        let topRated = books.sort((x1, x2)=> x2.likes.length - x1.likes.length).splice(0,3);

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

export default bookFetchReduxHoc(TopRatedBooks);
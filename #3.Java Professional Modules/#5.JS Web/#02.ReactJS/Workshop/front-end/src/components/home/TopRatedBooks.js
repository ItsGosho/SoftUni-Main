import React, {Component} from 'react';
import RoutingURLs from "../../constants/routing.url.constants";
import bookFetchReduxHoc from "../../redux/book/hocs/book.fetch.hoc";
import BookIterator from "../book/BookIterator";

class TopRatedBooks extends Component {


    render() {


        return (
            <div className="row">
                <BookIterator/>
            </div>
        );
    }
}

export default TopRatedBooks;
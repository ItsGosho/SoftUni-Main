import React, {Component} from 'react';
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
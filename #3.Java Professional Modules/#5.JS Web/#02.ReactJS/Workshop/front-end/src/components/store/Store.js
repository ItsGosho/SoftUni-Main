import React, {Component} from 'react';
import BookIterator from "../book/BookIterator";


class Store extends Component {

    render() {
        let books = [];

        return (
            <div className="container">
                <div className="row space-top">
                    <div className="col-md-12">
                        <h1 className="jumbotron-heading text-center">Store</h1>
                        <form className="form-inline md-form form-sm active-cyan active-cyan-2">
                            <i className="fa fa-search" aria-hidden="true"/>
                            <input className="form-control form-control-sm ml-3 w-75" type="text"
                                   placeholder="Search for the book you are looking for..." aria-label="Search"
                                   name="query" value=""/>
                        </form>
                    </div>
                </div>
                <div className="row">
                    <BookIterator/>
                </div>
                <div className="row space-top">
                    <div className="col-md-12">
                        <ul className="pagination">
                            <li className="page-item disabled"><a className="page-link" href="/store/0">«</a></li>
                            <li className="page-item active"><a className="page-link" href="/store/1">1</a></li>
                            <li className="page-item disabled"><a className="page-link" href="/store/2">»</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}

export default Store;
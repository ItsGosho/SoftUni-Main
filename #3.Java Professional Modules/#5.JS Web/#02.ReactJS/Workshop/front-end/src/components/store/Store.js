import React, {Component} from 'react';


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
                    <div className="card-deck space-top">
                        <div className="card col-4">
                            <img className="card-img-top card-image"
                                                         src="https://images-na.ssl-images-amazon.com/images/I/51fonMmNpnL.jpg"
                                                         alt="Harry Potter"/>
                            <div className="card-body">
                                <h5 className="card-title">Harry Potter</h5>
                                <p className="card-text">Harry Potter and the Philosopher's Stone is a fantasy novel
                                    written by British author J. K. Rowling.</p>
                            </div>
                            <div className="card-footer">
                                <small className="text-muted"/>
                                <a type="button" className="btn btn-primary float-right btn-sm" href="/details/5c750355eba4543e800f7ce4">Details</a>
                                <button type="button" className="btn btn-warning float-right btn-sm">Order</button>
                            </div>
                        </div>
                        <div className="card col-4">
                            <img className="card-img-top card-image"
                                                         src="https://images-na.ssl-images-amazon.com/images/I/419M8dJUa-L._SY346_.jpg"
                                                         alt="What the Wind Knows "/>
                            <div className="card-body">
                                <h5 className="card-title">What the Wind Knows </h5>
                                <p className="card-text">Anne Gallagher grew up enchanted by her grandfather’s stories
                                    of Ireland. Heartbroken at his death, she travels to his childhood home to spread
                                    his ashes.</p>
                            </div>
                            <div className="card-footer">
                                <small className="text-muted"/>
                                <a type="button"
                                   className="btn btn-primary float-right btn-sm" href="/details/5c75009b6fa7f81b2459134e">Details</a>
                                <button type="button" className="btn btn-warning float-right btn-sm">Order</button>
                            </div>
                        </div>
                    </div>
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
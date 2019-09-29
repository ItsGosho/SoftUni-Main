import React, {Component} from 'react';
import {Link} from "react-router-dom";
import RoutingURLs from "../../constants/routing.url.constants";

class Cart extends Component {

    render() {
        let checkoutBooks = [];

        return (
            <div className="container">
                <table id="cart" className="table table-hover table-condensed">
                    <thead>
                    <tr>
                        <th style={{'width':'50px'}}>Product</th>
                        <th style={{'width':'10px'}}>Price</th>
                        <th className="text-center" style={{'width':'22px'}}>Subtotal</th>
                        <th style={{'width':'10px'}}/>
                    </tr>
                    </thead>
                    <tbody>
                    {checkoutBooks.map((book, index) => {
                        let {id, title, image, genres, price} = book;

                        return (
                            <tr>
                                <td data-th="Product">
                                    <div className="row">
                                        <div className="col-sm-4 hidden-xs">
                                            <img src={image}
                                                 alt="..." className="cart-image"/>
                                        </div>
                                        <div className="col-sm-8">
                                            <h4 className="nomargin">{title}</h4>
                                            <p>{genres}</p>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">${price}</td>
                                <td className="actions" data-th="">
                                    {/*TODO: refresh it*/}
                                    <button className="btn btn-info btn-sm">
                                        <i className="fa fa-refresh"/>
                                    </button>
                                    {/*TODO: remove from cart*/}
                                    <button className="btn btn-danger btn-sm">
                                        <i className="fa fa-trash-o"/>
                                    </button>
                                </td>
                            </tr>
                        );
                    })}
                    </tbody>
                    <tfoot>
                    <tr>
                        <td>
                            <Link className="btn btn-warning" to={RoutingURLs.OTHER.STORE}>
                                <i className="fa fa-angle-left"/> Continue Shopping
                            </Link>
                        </td>
                        <td colSpan="2" className="hidden-xs"/>
                        <td className="hidden-xs text-center">
                            <strong>Total $10.00</strong>
                        </td>
                        <td>
                            <button className="btn btn-success btn-block">Checkout
                                <i className="fa fa-angle-right"/>
                            </button>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        );
    }
}

export default Cart;
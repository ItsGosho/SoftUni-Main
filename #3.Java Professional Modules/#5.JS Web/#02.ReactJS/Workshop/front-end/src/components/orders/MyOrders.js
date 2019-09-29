import React,{Component} from 'react';

class MyOrders extends Component {

    render() {

        return (
            <div className="container" style="padding-top: 25px;">
                <h1 className="text-center">My Orders</h1>
                <div className="row" style="padding-top: 25px;">
                    <div className="col-md-12" id="customer-orders">
                        <div className="box">
                            <div className="table-responsive">
                                <table className="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Date</th>
                                        <th>Total</th>
                                        <th>Status</th>
                                        <th>View</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>#1</th>
                                        <td>27.02.2019 г., 16:46:02 ч.</td>
                                        <td>$ 5.00</td>
                                        <td><span className="label label-info">Approved</span></td>
                                        <td><a className="btn btn-outline-warning btn-sm"
                                               href="/orders/details/5c76a2aa157aaa2c6084dc54">View</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default MyOrders;
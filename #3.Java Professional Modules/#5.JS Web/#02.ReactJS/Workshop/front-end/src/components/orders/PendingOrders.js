import React,{Component} from 'react';

class PendingOrders extends Component {

    render() {

        return (
            <div className="container" style={{'paddingTop': '25px'}}>
                <h1 className="text-center">Pending Orders</h1>
                <div className="row" style={{'paddingTop': '25px'}}>
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
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>#1</th>
                                        <td>27.02.2019 г., 16:55:02 ч.</td>
                                        <td>$ 10.00</td>
                                        <td><span className="label label-info">Pending</span></td>
                                        <td><a className="btn btn-outline-warning btn-sm"
                                               href="/orders/details/5c76a4c6157aaa2c6084dc55">View</a></td>
                                        <td>
                                            <button className="btn btn-outline-success btn-sm">Approve</button>
                                        </td>
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

export default PendingOrders;
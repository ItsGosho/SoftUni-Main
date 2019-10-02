import React,{Fragment,Component} from 'react';
import './App.css';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import ReactNotification from "react-notifications-component";
import RoutingURLs from "../constants/routing.url.constants";
import Footer from "./footer/Footer";
import Navigation from "./navigation/Navigation";
import Home from "./home/Home";
import Store from "./store/Store";
import Cart from "./cart/Cart";
import Login from "./authentication/Login";
import Register from "./authentication/Register";
import Logout from "./authentication/Logout";
import CreateBook from "./book/CreateBook";
import MyOrders from "./orders/MyOrders";
import PendingOrders from "./orders/PendingOrders";
import guestReduxHoc from "../hoc/guest.hoc";
import roleReduxHoc from "../hoc/role.hoc";
import Roles from "../constants/roles.constants";
import authenticatedReduxHoc from "../hoc/authenticated.hoc";
import NotificationHelper from "../helpers/notification.helper";


class App extends Component {

  render() {
    return (
        <div className="App">
            <BrowserRouter>
              <Fragment>
                <ReactNotification/>

                <Route component={() => <Navigation/>}/>

                <Switch>
                  <Route exact path={RoutingURLs.HOME} component={Home}/>

                  <Route exact path={RoutingURLs.OTHER.STORE} component={authenticatedReduxHoc(Store)}/>
                  <Route exact path={RoutingURLs.OTHER.CART} component={authenticatedReduxHoc(Cart)}/>

                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={guestReduxHoc(Login)}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={guestReduxHoc(Register)}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGOUT} component={Logout}/>

                  <Route exact path={RoutingURLs.BOOK.CREATE} component={roleReduxHoc(CreateBook,Roles.ADMIN)}/>
                  <Route exact path={RoutingURLs.BOOK.DETAILS} component={null}/>

                  <Route exact path={RoutingURLs.ORDER.MY} component={authenticatedReduxHoc(MyOrders)}/>
                  <Route exact path={RoutingURLs.ORDER.PENDING} component={roleReduxHoc(PendingOrders,Roles.ADMIN)}/>

                  <Route component={() => {
                    NotificationHelper.showErrorNotification('Page not found!');
                    return null;
                  }}/>
                </Switch>

                <Route component={() => <Footer/>}/>

              </Fragment>
            </BrowserRouter>
        </div>
    );
  }
}

export default App;

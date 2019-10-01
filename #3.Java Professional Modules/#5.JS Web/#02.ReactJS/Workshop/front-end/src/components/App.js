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
import guestHoc from "../hoc/guest.hoc";


class App extends Component {

  render() {
    return (
        <div className="App">
            <BrowserRouter>
              <Fragment>
                <ReactNotification/>

                <Route component={() => <Navigation/>}/>

                <Switch>
                  <Route exact path={RoutingURLs.HOME} component={() => <Home/>}/>

                  <Route exact path={RoutingURLs.OTHER.STORE} component={() => <Store/>}/>
                  <Route exact path={RoutingURLs.OTHER.CART} component={() => <Cart/>}/>

                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={guestHoc(Login)}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={() => <Register/>}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGOUT} component={() => <Logout/>}/>

                  <Route exact path={RoutingURLs.BOOK.CREATE} component={() => <CreateBook/>}/>
                  <Route exact path={RoutingURLs.BOOK.DETAILS} component={() => null}/>

                  <Route exact path={RoutingURLs.ORDER.MY} component={() => <MyOrders/>}/>
                  <Route exact path={RoutingURLs.ORDER.PENDING} component={() => <PendingOrders/>}/>

                  <Route component={() => (<h1>Not found</h1>)}/>
                </Switch>

                <Route component={() => <Footer/>}/>

              </Fragment>
            </BrowserRouter>
        </div>
    );
  }
}

export default App;

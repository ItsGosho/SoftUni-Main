import React, {Component, Fragment} from 'react';
import {Route, Switch, BrowserRouter} from 'react-router-dom';
import RoutingURLs from "../constants/routing.url.constants";
import './App.css';

import Home from './Home/Home';
import Register from './Register/Register';
import Login from './Login/Login';
import MovieCreate from './Movie/MovieCreate';
import Navigation from "./Navigation/Navigation";
import ReactNotification from "react-notifications-component";
import CookieHelper from "../helpers/cookie.helper";
import Logout from "./Logout/Logout";

class App extends Component {

    constructor(props) {
        super(props);

        this.getUsername = this.getUsername.bind(this);
        this.getRole = this.getRole.bind(this);
    }

    getUsername() {
        return CookieHelper.getCookie('username');
    }

    getRole() {
        return CookieHelper.getCookie('role');
    }

    render() {

        return (
            <div className="App">
                <BrowserRouter>
                    <Fragment>
                        <ReactNotification/>
                        <Route component={()=> <Navigation roleName={this.getRole()} username={this.getUsername()}/>}/>
                        <Switch>
                            <Route exact path={RoutingURLs.HOME} component={() => <Home roleName={this.getRole()}/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={() => <Login/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={() => <Register/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.LOGOUT} component={() => <Logout/>}/>
                            <Route exact path={RoutingURLs.MOVIE.CREATE} component={() => <MovieCreate/>}/>
                        </Switch>
                    </Fragment>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;

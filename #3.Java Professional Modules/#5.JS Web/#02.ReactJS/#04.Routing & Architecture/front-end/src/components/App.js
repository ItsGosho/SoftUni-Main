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
import loggedOut from "./hoc/logged_out.hoc";
import Role from "./hoc/role.hoc";
import {UserProvider} from "./contexts/user.context";

class App extends Component {

    render() {
        return (
            <div className="App">
                <UserProvider>
                    <BrowserRouter>
                        <Fragment>
                            <ReactNotification/>
                            <Route component={() => <Navigation/>}/>
                            <Switch>
                                <Route exact path={RoutingURLs.HOME} component={() => <Home/>}/>
                                <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={loggedOut(Login)}/>
                                <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={loggedOut(Register)}/>
                                <Route exact path={RoutingURLs.AUTHENTICATION.LOGOUT} component={Logout}/>
                                <Route exact path={RoutingURLs.MOVIE.CREATE} component={Role(MovieCreate, 'Admin')}/>
                            </Switch>
                        </Fragment>
                    </BrowserRouter>
                </UserProvider>
            </div>
        );
    }
}

export default App;

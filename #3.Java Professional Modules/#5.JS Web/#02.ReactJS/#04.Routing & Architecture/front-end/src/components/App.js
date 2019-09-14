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

class App extends Component {

    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <Fragment>
                        <ReactNotification/>
                        <Navigation roleName="Guest" username="Joreto"/>
                        <Switch>
                            <Route exact path={RoutingURLs.HOME} component={() => <Home roleName="Guest"/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={() => <Login/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={() => <Register/>}/>
                            <Route exact path={RoutingURLs.MOVIE.CREATE} component={() => <MovieCreate/>}/>
                        </Switch>
                    </Fragment>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
